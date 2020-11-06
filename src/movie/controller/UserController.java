package movie.controller;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

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
	 * 	유저 쪽지 전체 목록 불러오기
	 */
	public ModelAndView getUserLetterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserLetterList
	
	/**
	 *	유저 알람 확인
	 */
	public ModelAndView getUserNotification(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserNotification
	
	/**
	 * 	유저 가입 당시 아이피 확인
	 */
	public ModelAndView getUserFirstIP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserFirstIP
	
	/**
	 * 	유저 마지막 로그인 아이피 확인
	 */
	public ModelAndView getUserLastIP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserLastIP
	
	/**
	 * 	유저 가입 당시 날짜 확인
	 */
	public ModelAndView getUserFirstDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserFirstDate
	
	/**
	 * 	유저 마지막 로그인 날짜 확인
	 */
	public ModelAndView getUserLastDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//getUserLastDate
	
	/**
	 * 	유저 마지막 로그인 날짜 갱신
	 */
	public ModelAndView updateUserLastDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//updateUserLastDate
	
	/**
	 *	계정 잠금
	 */
	public ModelAndView setUserLock(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}//setUserLock

}// class
