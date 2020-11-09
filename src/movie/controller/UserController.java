package movie.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.UserDTO;
import movie.service.UserService;


public class UserController implements Controller {
	
	private UserService service = new UserService();
	private ModelAndView mv = new ModelAndView();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

	
	/**
	 * 유저 고유 아이디 확인
	 */
	public ModelAndView getUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserId
	

	/**
	 * 유저 정보 확인
	 * @param1	int [userlist 테이블] u_id
	 * @param2	HttpSession session (로그인 할 때만 값을 주고 그 외에는 null)
	 * @return UserDTO
	 * @throws SQLException
	 */
	public UserDTO getUserInfo(int uid, HttpSession session) throws SQLException {
		return service.getUserInfo(uid, session);
	}

	/**
	 * 계정 잠금 여부 확인
	 */
	public ModelAndView getUserLocked(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserLocked

	/**
	 * 유저 마지막 로그인 날짜/IP 갱신
	 */
	public ModelAndView updateUserLastLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//updateUserLastLogin

	/**
	 * 유저 활동 포인트 설정
	 */
	public ModelAndView setUserPoints(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//setUserPoints

	/**
	 * 유저 활동 포인트 확인
	 */
	public ModelAndView getUserPoints(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserPoints

	/**
	 * 유저 등급 아이디 확인
	 */
	public ModelAndView getUserRoleId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserRoleId

	/**
	 * 유저 등급 아이디 설정
	 */
	public ModelAndView setUserRoleId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//setUserRoleId

	/**
	 * 유저 성인 등급 열람 여부 설정
	 */
	public ModelAndView setUserViewAdult(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//setUserViewAdult

	/**
	 * 유저 성인 등급 열람 여부 확인
	 */
	public ModelAndView getUserViewAdult(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserViewAdult
	
	/**
	 * 유저 닉네임 수정
	 * */
	
	public ModelAndView updateUserNickname(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("updateUserNickname 호출...");
		int uid =(int)session.getAttribute("uid");
		String nickname = request.getParameter("nickname");
		System.out.println("uid" + uid);
		System.out.println("nickname" + nickname);
		if (UserService.updateUserNickname(uid, nickname)) {
			UserDTO user = UserService.getUserInfo(uid, null);
			user.setName(nickname);
			session.setAttribute("nickname", nickname);
		}
		ModelAndView mv = new ModelAndView();
		PrintWriter out = response.getWriter();
		mv.setViewName("mainView/profile/manageMyProfileCenter.jsp");
		
		return mv;

	}//updateUserNickname

}// class
