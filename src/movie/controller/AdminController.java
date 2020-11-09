package movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.PointShop;
import movie.dto.UserDTO;
import movie.service.AdminService;

public class AdminController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	/**
	 * 	유저의 관리자 여부 확인
	 * */
	public ModelAndView checkAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid"); 
		AdminService.checkAdmin(uid);
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//checkAdmin

	/**
	 * 	회원 정보 (검색)
	 * */
	public ModelAndView AdminSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<UserDTO> list = AdminService.AdminSearch();
		request.setAttribute("list", list);
		String path = request.getServletContext().getRealPath("/");
		ModelAndView mv = new ModelAndView();
		mv.setViewName(path + "/adminView/user/userList.jsp");
		return mv;
	}//AdminSearch

	/**
	 * 	회원 정보 (삭제)
	 * */
	public ModelAndView AdminDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		
		AdminService.AdminDelete(uid);
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//AdminDelete
	
	/**
	 * 	회원 블랙 리스트 등록(아이디 차단)
	 * */
	public ModelAndView AdminBlackList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		String locked = request.getParameter("account_locked");
		
		AdminService.AdminBlackList(uid,Integer.parseInt(locked));
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	/**
	 * 	게시물 (수정)
	 * */
	public ModelAndView AdminBoardUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid =(int)session.getAttribute("uid");
		String text = request.getParameter("text");
		String title = request.getParameter("title");
				
		AdminService.AdminBoardUpdate(uid, text, title);
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	/**
	 * 	게시물 (삭제)
	 * */
	public ModelAndView AdminBoardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		//String path = request.getServletContext().getRealPath("/save");
		
		AdminService.AdminBoardDelete(uid);
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	/**
	 * 포인트 상점 관리(추가)
	 */
	public ModelAndView AdminPointInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid= (int)session.getAttribute("uid");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String point = request.getParameter("point");
		String stock = request.getParameter("stock");
		String fileId = request.getParameter("fileId");
		String reqRoldId = request.getParameter("reqRoldId");
		String locked = request.getParameter("locked");

		PointShop pointshop = new PointShop(uid, name, type, Integer.parseInt(point),
				Integer.parseInt(stock), Integer.parseInt(fileId), Integer.parseInt(reqRoldId),
				Integer.parseInt(locked));

		AdminService.AdminPointInsert(pointshop);
		ModelAndView mv = new ModelAndView();

		return mv;
	}

	/**
	 * 포인트 상점 관리(수정)
	 */
	public ModelAndView AdminPointUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String stock = request.getParameter("stock");
		
		AdminService.AdminPointUpdate(uid, name, type, Integer.parseInt(stock));
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	/**
	 * 포인트 상점 관리(삭제)
	 */
	public ModelAndView AdminPointDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid =(int)session.getAttribute("uid");
		
		PointShop pointshop = new PointShop(uid);
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	
	
	
	
}//class

















