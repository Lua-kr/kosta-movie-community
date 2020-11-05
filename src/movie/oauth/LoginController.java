package movie.oauth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		if (accessToken == null) {
			String authCode = request.getParameter("code");
			System.out.println("auth code: " + authCode);
			if (authCode != null) accessToken = kakaoapi.getAccessToken(authCode);
		}
		else {
			System.out.println("loaded access_token: " + accessToken);
		}

		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		if (accessToken != null) {
			userInfo = kakaoapi.getUserInfo(accessToken);
			System.out.println("user info: " + userInfo);
		}
		
		PrintWriter pw = response.getWriter();
		if (userInfo.get("uid") != null) {
			if (!(Boolean) userInfo.get("has_email")) {
				LoginErrorRedirect("Email 정보가 없습니다.\\n\\n카카오 계정에 등록해주세요.", "카카오 계정 관리 페이지로 가기", "https://accounts.kakao.com/weblogin/account/info/email", pw, request.getContextPath());
				return;
			}
			
			boolean needAgreeEmail = (Boolean) userInfo.get("email_needs_agreement");
			boolean needAgreeAgeRange = (Boolean) userInfo.get("age_range_needs_agreement");
			if (needAgreeEmail || needAgreeAgeRange) {
				response.sendRedirect(kakaoapi.kakaoAuthorizeAccessURL(accessToken, "account_email,age_range"));
				return;
			}
			session.setAttribute("email", userInfo.get("email"));
			session.setAttribute("access_Token", accessToken);
			session.setAttribute("nickname", userInfo.get("nickname"));
			session.setAttribute("age_range", userInfo.get("age_range"));
			session.setAttribute("profile_img", userInfo.get("profile_img"));
			session.setAttribute("uid", userInfo.get("uid"));

	        request.getRequestDispatcher("/").forward(request, response);
		} else {
			pw.append("<script>alert('사용자 정보가 없습니다.\\n\\n다시 로그인하세요.');");
			pw.append("location.href = '" + request.getContextPath() + "/login.jsp';");
			pw.append("</script>");
		}
	}
	
	private void LoginErrorRedirect(String alert, String msg, String URL, PrintWriter pw, String path) {
		pw.append("<html>");
		pw.append("<body>");
		pw.append("<a href='" + URL + "' target='_blank'><h1>" + msg + "</h1></a>");
		pw.append("<a href='#' onclick='history.back()'><h3>뒤로가기</h3></a>");
		pw.append("<script>alert('" + alert + "');</script>");
		pw.append("</body>");
		pw.append("</html>");
	}

}
