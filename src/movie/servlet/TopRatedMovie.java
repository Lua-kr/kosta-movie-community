package movie.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class TopRated
 */
@WebServlet("/toprated")
public class TopRatedMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("top doget");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		BufferedReader br;
		try {
			String urlstr = "https://api.themoviedb.org/3/movie/top_rated?&language=en-US&page=1&api_key=1409aaea037c127f018d970de4a17783";
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
				//response.getWriter().append(result + "<hr>");

				// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
				JsonElement element = new JsonParser().parse(result);
				JsonArray results = element.getAsJsonObject().get("results").getAsJsonArray();
				JsonObject obj ;
				
				System.out.println("results : " + results);
				
				Map<String, JsonObject>map = new HashMap<String, JsonObject>();
				for (int i = 0; i < results.size(); i++) {
					//System.out.println("index " + i + " =  " + results.get(i) + "\n");
					obj = (JsonObject) results.get(i);
					
					
					map.put(Integer.toString(i), obj);
				}
				request.setAttribute("map", map);
				
				br.close();
				
				request.getRequestDispatcher("topratedSuccess.jsp").forward(request, response);

			} // if
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("search Error: " + e.getMessage());
		} // catch

	}//doget


}//class
