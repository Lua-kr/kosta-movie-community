package movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.service.BoardService;

public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	public ModelAndView insertReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	public ModelAndView updateReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uid = request.getParameter("uid");
		String authorid = request.getParameter("authorid");
		String text = request.getParameter("text");
		String title = request.getParameter("title");
		
		BoardService.updateReview(Integer.parseInt(uid), Integer.parseInt(authorid), text, title);
		ModelAndView mv = new ModelAndView("", false);
		return mv;
	}
	
	public ModelAndView deleteReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uid = request.getParameter("uid");
		String authorid = request.getParameter("authorid");
		
		BoardService.deleteReview(Integer.parseInt(uid), Integer.parseInt(authorid));
		ModelAndView mv = new ModelAndView("", false);
		
		return mv;
	}


	
	
	
	
	
	
	
	
}//class















