package movie.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class Detail
 */
@WebServlet("/detail")
public class MovieDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("detail doget");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String code = request.getParameter("code");

		BufferedReader br;
		try {
			String urlstr = "https://api.themoviedb.org/3/movie/"+code+"?api_key=1409aaea037c127f018d970de4a17783&language=ko-kr";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");

			// 결과 코드가 200이라면 성공
			int responseCode = urlconnection.getResponseCode();
			//System.out.println("search responseCode : " + responseCode);

			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
				String result = "";
				String line = "";
				while ((line = br.readLine()) != null) {
					result += line;
				}
				response.getWriter().append(result + "<hr>");
				System.out.println("result : "+result);

				// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
				JsonElement element = new JsonParser().parse(result);
				
				
				String original_title =element.getAsJsonObject().get("original_title").getAsString();
				String budget =element.getAsJsonObject().get("budget").getAsString();
				String overview =element.getAsJsonObject().get("overview").getAsString();
				String popularity =element.getAsJsonObject().get("popularity").getAsString();
				String poster_path =element.getAsJsonObject().get("poster_path").getAsString();
				String release_date =element.getAsJsonObject().get("release_date").getAsString();
				String revenue =element.getAsJsonObject().get("revenue").getAsString();
				String runtimes =element.getAsJsonObject().get("runtime").getAsString();
				String tagline =element.getAsJsonObject().get("tagline").getAsString();
				String vote_average =element.getAsJsonObject().get("vote_average").getAsString();
				String vote_count =element.getAsJsonObject().get("vote_count").getAsString();
				String title =element.getAsJsonObject().get("title").getAsString();
				
				 if (!title.equals("")) {
		            	request.setAttribute("title", title);
				 }else {
		            	request.setAttribute("title", "title 존재하지 않습니다");
				 }
				 if (!original_title.equals("")) {
		            	request.setAttribute("original_title", original_title);
				 }else {
		            	request.setAttribute("original_title", "original_title 존재하지 않습니다");
				 }
				 if (!budget.equals("")) {
		            	request.setAttribute("budget", budget);
				 }else {
		            	request.setAttribute("budget", "budget 존재하지 않습니다");
				 }
				 if (!overview.equals("")) {
		            	request.setAttribute("overview", overview);
				 }else {
		            	request.setAttribute("overview", "overview 존재하지 않습니다");
				 }
				 if (!popularity.equals("")) {
		            	request.setAttribute("popularity", popularity);
				 }else {
		            	request.setAttribute("popularity", "popularity 존재하지 않습니다");
				 }
				 if (!poster_path.equals("")) {
		            	request.setAttribute("poster_path", poster_path);
				 }else {
		            	request.setAttribute("poster_path", "poster_path 존재하지 않습니다");
				 }
				 if (!release_date.equals("")) {
		            	request.setAttribute("release_date", release_date);
				 }else {
		            	request.setAttribute("release_date", "release_date 존재하지 않습니다");
				 }
				 if (!revenue.equals("")) {
		            	request.setAttribute("revenue", revenue);
				 }else {
		            	request.setAttribute("revenue", "revenue 존재하지 않습니다");
				 }
				 if (!runtimes.equals("")) {
		            	request.setAttribute("runtimes", runtimes);
				 }else {
		            	request.setAttribute("runtimes", "runtimes 존재하지 않습니다");
				 }
				 if (!tagline.equals("")) {
		            	request.setAttribute("tagline", tagline);
				 }else {
		            	request.setAttribute("tagline", "tagline 존재하지 않습니다");
				 }
				 if (!vote_average.equals("")) {
		            	request.setAttribute("vote_average", vote_average);
				 }else {
		            	request.setAttribute("vote_average", "vote_average 존재하지 않습니다");
				 }
				 if (!vote_count.equals("")) {
		            	request.setAttribute("vote_count", vote_count);
				 }else {
		            	request.setAttribute("vote_count", "vote_count 존재하지 않습니다");
				 }
				 
				
				System.out.println("title = "+title);
				System.out.println("budget = "+budget);
				System.out.println("overview = "+overview);
				System.out.println("popularity = "+popularity);
				System.out.println("poster_path = "+poster_path);
				System.out.println("release_date = "+release_date);
				System.out.println("revenue = "+revenue);
				System.out.println("runtimes = "+runtimes);
				System.out.println("tagline = "+tagline);
				System.out.println("vote_average = "+vote_average);
				System.out.println("vote_count = "+vote_count);
				
				
				br.close();
				
				request.getRequestDispatcher("detailSuccess.jsp").forward(request, response);

			} // if
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("search Error: " + e.getMessage());
		} // catch

		
		
	}//doget


}//class
