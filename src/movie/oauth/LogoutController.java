package movie.oauth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class KakaoLogout
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	KakaoAPI kakaoapi = new KakaoAPI();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String accessTokenId = (String)session.getAttribute("access_Token");
		if (accessTokenId != null && accessTokenId.length() > 0) {
			System.out.println("logged out: " + session.getAttribute("nickname") + " (" + session.getAttribute("uid") + ")");
			kakaoapi.kakaoLogout(accessTokenId);
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('성공적으로 로그아웃 되었습니다.'); location.href = '" + request.getContextPath() + "/';</script>");
			session.invalidate();
		}
		else response.sendRedirect(request.getContextPath() + "/");
	}

}
