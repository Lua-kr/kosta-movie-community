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
				pw.println("<script>var kakaoEmail = confirm('Email 정보가 없습니다.\\n\\n카카오 계정 관리 페이지로 이동하시겠습니까?'); if (kakaoEmail) location.href = 'https://accounts.kakao.com/weblogin/account/info/email'; else location.href = '" + request.getContextPath() + "/';</script>");
				return;
			}
			
			if ((Boolean) userInfo.get("email_needs_agreement") || (Boolean) userInfo.get("age_range_needs_agreement")) {
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
			pw.append("<script>alert('사용자 정보가 없습니다.\\n\\n다시 로그인 해주세요.');");
			pw.append("location.href = '" + request.getContextPath() + "/';");
			pw.append("</script>");
		}
	}
}
