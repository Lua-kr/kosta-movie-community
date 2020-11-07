package movie.oauth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.UserDTO;
import movie.service.AdminService;
import movie.service.UserService;

/**
 * Servlet implementation class KakaoLogin
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	KakaoAPI kakaoapi = new KakaoAPI();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String accessToken = "";
		if (!session.isNew()) accessToken = (String) session.getAttribute("access_Token");
		if (accessToken == null || accessToken.length() < 5) {
			String authCode = request.getParameter("code");
//			System.out.println("auth code: " + authCode);
			if (authCode != null) accessToken = kakaoapi.getAccessToken(authCode);
		}
		else {
//			System.out.println("loaded access_token: " + accessToken);
		}

		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		if (accessToken != null) {
			userInfo = kakaoapi.getUserInfo(accessToken);
//			System.out.println("user info: " + userInfo);
		}
		
		PrintWriter pw = response.getWriter();
		if (userInfo.get("uid") != null) {
			if (!(Boolean) userInfo.get("has_email")) {
				pw.println("<script>var kakaoEmail = confirm('Email 정보가 없습니다.\\n\\n카카오 계정 관리 페이지로 이동하시겠습니까?'); if (kakaoEmail) location.href = 'https://accounts.kakao.com/weblogin/account/info/email'; else location.href = '" + request.getContextPath() + "/';</script>");
				return;
			}
			
			if ((Boolean) userInfo.get("email_needs_agreement") || (Boolean) userInfo.get("age_range_needs_agreement")) {
				response.sendRedirect(kakaoapi.kakaoAuthorizeAccessURL(accessToken, "account_email,age_range"));
				return;
			}
			
			int uid = Integer.parseInt((String)userInfo.get("uid"));
			session.setAttribute("uid", uid);
			UserDTO userClass = null;
			try {
				// 계정 잠금 확인
				if (UserService.isUserLocked(uid)) {
					loginFailed("계정이 잠겨있습니다.\\n\\n관리자에게 문의하세요.", accessToken, session, request.getContextPath(), pw);
					return;
				}
				
				// 관리자 확인
				if (AdminService.checkAdmin(uid)) {
					session.setAttribute("admin", 1);
					System.out.println("Admin: " + uid);
				}
				
				session.setAttribute("email", userInfo.get("email"));
				session.setAttribute("access_Token", accessToken);
				session.setAttribute("nickname", userInfo.get("nickname"));
				String ageRange = (String)userInfo.get("age_range");
				String [] ageArray = ageRange.split("~");
				int age = Integer.parseInt(ageArray[0]);
				session.setAttribute("age_range", age);
				session.setAttribute("profile_img", userInfo.get("profile_img"));
				String ip = request.getRemoteAddr();
				session.setAttribute("ip", ip);
				
				// 유저 정보 확인 및 유저 클래스 생성
				userClass = UserService.getUserInfo(uid, session);
				
				session.setAttribute("joinDate", userClass.getCreDate());
				session.setAttribute("points", userClass.getPoints());

				// 마지막 IP 갱신
				userClass.setLastIp(ip);
				
				// 마지막 날짜 갱신
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
				String today = sdf.format(System.currentTimeMillis());
				System.out.println(today);
				userClass.setLastDate(today);
//				userClass.setLastDate();

				UserService.updateUserLastLogin(userClass);

				// 성인 나이 설정
				boolean isAdult = userClass.isAgeAdult();
				if (age > 19) {
					if (!isAdult) {
						UserService.setUserAgeAdult(uid, true);
						userClass.setAgeAdult(true);
					}
					System.out.println("User: " + session.getAttribute("nickname") + " 님은 성인으로 확인되었습니다.");
					session.setAttribute("adult", true);
				}
				else {
					if (isAdult) {
						UserService.setUserAgeAdult(uid, false);
						userClass.setAgeAdult(false);
					}
					session.setAttribute("adult", false);
					System.out.println("User: " + session.getAttribute("nickname") + " 님은 미성년자로 확인되었습니다.");
				}
			} catch (SQLException e) {
				loginFailed("사용자 정보가 없습니다.\\n\\n다시 로그인 해주세요.", accessToken, session, request.getContextPath(), pw);
				e.printStackTrace();
				return;
			}
			
			// 로그인 성공
			System.out.println("logged in: " + session.getAttribute("nickname") + " (" + session.getAttribute("uid") + ")");
			
			
			// TODO: UPDATE LAST IP, DATE
			// TODO: CHECK ADMIN (Attribute admin), AGE ADULT

	        request.getRequestDispatcher("/").forward(request, response);
		} else {
			pw.println("<script>alert('사용자 정보가 없습니다.\\n\\n다시 로그인 해주세요.'); location.href = '" + request.getContextPath() + "/'; </script>");
		}
	}
	
	private void loginFailed(String msg, String accessToken, HttpSession session, String path, PrintWriter pw) {
		System.out.println("Log-in failed: " + session.getAttribute("uid"));
		session.invalidate();
		kakaoapi.kakaoLogout(accessToken);
		pw.println("<script>alert('" + msg + "'); location.href = '" + path + "'; </script>");
	}
}
