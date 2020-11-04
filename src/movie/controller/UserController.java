package movie.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import movie.service.UserService;


public class UserController implements Controller {
	
	private  UserService service = new UserService();
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
	 * 유저 로그인
	 */
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//userLogin

	/**
	 * 회원 로그아웃
	 */
	public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//userLogout

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
	 * 유저 활동 포인트 더하기/빼기
	 */
	public ModelAndView addUserPoints(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//addUserPoints

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

}// class
