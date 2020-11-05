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
 * Servlet implementation class KakaoLogout
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	KakaoAPI kakaoapi = new KakaoAPI();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();

		// 로그아웃
		String accessTokenId = (String)session.getAttribute("access_Token");
		session.invalidate();
		if (accessTokenId != null && accessTokenId.length() > 0) {
			System.out.println("logout: " + accessTokenId);
			kakaoapi.kakaoLogout(accessTokenId);
			PrintWriter pw = response.getWriter();
			pw.append("<script>alert('성공적으로 로그아웃되었습니다.');");
			pw.append("location.href = '" + request.getContextPath() + "/';");
			pw.append("</script>");
		}
		else response.sendRedirect(request.getContextPath() + "/");
	}

}
