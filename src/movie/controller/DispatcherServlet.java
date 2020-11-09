package movie.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dto.UserDTO;


/**
 * 사용자 요청을 중앙집중적으로 관리해줄
 * FrontConrtoller
 * 	: 사용자 요청을 받아서 그에 해당하는 Controller를
 * 	  찾아서 호출하고 그 결과(ModelAndView)를 받아서 해당하는
 * 	  뷰페이지로 이동시킨다.
 * */

@WebServlet(urlPatterns = "/app", loadOnStartup = 1 )
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;
	private Map<String, Class<?>> clzMap;
	
	@Override
		public void init() throws ServletException {
			map = (Map<String,Controller>)super.getServletContext().getAttribute("map");
			clzMap=(Map<String, Class<?>>)super.getServletContext().getAttribute("clzMap");
		}//init
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key= request.getParameter("k");
		String value =request.getParameter("v");
		System.out.println("app service (key: " + key + ", value: " + value + ")");
		if (key != null && !key.isEmpty()) {
			Controller con = map.get(key);
			Class<?> cls = clzMap.get(key);
			
			try {
				Method method =
						cls.getMethod(value, HttpServletRequest.class,HttpServletResponse.class);
				ModelAndView mv =(ModelAndView)method.invoke(con, request, response);
			
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getViewName());
				}else {
					request.getRequestDispatcher(mv.getViewName()).forward(request, response);
				}//else
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", e.getMessage());
				request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
			}//catch
		}
		else {
			request.setAttribute("errorMsg", "Bad Request");
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		}
	}//service

}//class