package movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.ForumPost;
import movie.dto.ForumThread;
import movie.service.BoardService;
import movie.service.ForumPostService;
import movie.service.FreeBoardService;

public class BoardController implements Controller {
	BoardService service = new BoardService();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

///////////////////////////////////////////////		reviewController	///////////////////////////////////////////////////////////////
	/**등록*/
	public ModelAndView insertReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		String text = request.getParameter("text");
		String title = request.getParameter("title");
		String movieId = request.getParameter("movieId");
		String rate = request.getParameter("rate");
		
		
		//인수 넣어서 서비스 보내서 forum_thread 에 insert돌리고 리턴 thread로 하고
		int threadNo =service.insert(new ForumThread(uid,text,title));  
		
		
		
		if (threadNo != 0) { //유효성 체크한후에 serivce.addReview(thread)// thread랑
			if(categoryNo == 0) {//자유게시판
				service.insert(new ForumThread(0, 0, 0, uid, 0, 0, 0, text, title, null));
			}//if
			else if(categoryNo == 1) {//댓글
				ForumPostService.addPost(threadNo, uid, text);
			}//else if
			else if(categoryNo == 2) {//리뷰
				service.addReview(threadNo,movieId,rate);
			}//else if
		}//if
		
		ModelAndView mv = new ModelAndView("", true);
		return mv;
		
	}
	
	/**수정*/
	public ModelAndView updateReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uid = request.getParameter("uid");
		String authorid = request.getParameter("authorid");
		String text = request.getParameter("text");
        String title = request.getParameter("title");
		      
		service.updateReview(Integer.parseInt(uid), Integer.parseInt(authorid), text, title);
		ModelAndView mv = new ModelAndView("", false);
		return mv;
	}
	
	/**삭제*/
	public ModelAndView deleteReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uid = request.getParameter("uid");
		String authorid = request.getParameter("authorid");
		      
		service.deleteReview(Integer.parseInt(uid), Integer.parseInt(authorid));
		ModelAndView mv = new ModelAndView("", false);
		
		      
		return mv;
	}		
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	////////////////////////////////////FreeBoard////////////////////////////////
	public ModelAndView freeBoardInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String text = request.getParameter("text");
		String title = request.getParameter("title");
		
		ForumThread thread = new ForumThread(0, 0, 0, 0, 0, 0, 0, text, title, null);
		
		FreeBoardService.freeBoardInsert(thread);
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//freeBoardInsert
	
	
	public ModelAndView freeBoardUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		String text = request.getParameter("text");
		String title = request.getParameter("title");
		
		FreeBoardService.freeBoardUpdate(uid, text, title);
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//freeBoardUpdate
	
	
	
	public ModelAndView freeBoardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		
		FreeBoardService.freeBoardDelete(uid);
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//freeBoardDelete
	
	
	
	////////////////////////////////////FreeBoard////////////////////////////////
	public ModelAndView forumPostInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String text = request.getParameter("text");
		
		ForumPost post = new ForumPost(0, text, 0, 0, 0, null);
		ForumPostService.forumPostInsert(post);
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//forumPostInsert
	
	
	
	public ModelAndView forumPostUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		String text = request.getParameter("text");
		ForumPostService.forumPostUpdate(uid, text);
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//forumPostUpdate



	public ModelAndView forumPostDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		ForumPostService.forumPostDelete(uid);
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}//forumPostDelete
	
	
	
	
	
	
	
	
	
	
	
	
}//class















