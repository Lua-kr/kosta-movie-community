package movie.service;

import java.sql.SQLException;

import movie.dao.AdminDAO;
import movie.dao.AdminDAOImpl;
import movie.dto.PointShop;
import movie.dto.UserDTO;

public class AdminService {
	private static AdminDAO dao = new AdminDAOImpl();
	
	/**
	 *	유저의 관리자 여부 확인
	 *
	 * @param	int [userlist 테이블] u_id
	 * @return	관리자 여부 (0/1 = false/true)
	 */
	public static boolean checkAdmin(int uid) throws SQLException {
		return true;
	}//checkAdmin
	
	
	/*
	 *	회원 정보 (검색)
	 */
	public static boolean AdminSearch(UserDTO user) throws SQLException{
		boolean result = dao.AdminSearch(user);
		if(!result) {
			throw new SQLException("회원 정보 검색 실패");
		}//if
		return result;
	}//AdminSearch
	
	/*
	 *	회원 정보 (삭제)
	 */
	public static boolean AdminDelete(int uid) throws SQLException{
		boolean result = dao.AdminDelete(uid);
		if(!result) {
			throw new SQLException("회원 정보 삭제 실패");
		}//if
		return result;
	}//AdminDelete
	
	
	/*
	 *	회원 블랙 리스트 등록(아이디 차단)
	 */
	public static int AdminBlackList(int uid, int locked) throws SQLException{
		int result = dao.AdminBlackList(uid, locked);
		if(result == 0) {
			throw new SQLException("블랙 리스트 등록 실패");
		}//if
		return result;
	}//AdminBlackList
	
	
	/*
	 *	게시물 (수정)
	 */
	public static boolean AdminBoardUpdate(int uid, String text, String title) throws SQLException{
		boolean result = dao.AdminBoardUpdate(uid, text, title);
		if(!result) {
			throw new SQLException("게시물 수정 실패");
		}//if
		return result;
	}//AdminBoardUpdate
	
	
	/*
	 *	게시물 (삭제)
	 */
	public static boolean AdminBoardDelete(int uid) throws SQLException{
		boolean result = dao.AdminBoardDelete(uid);
		if(!result) {
			throw new SQLException("게시물 삭제 실패");
		}//if
		return result;
	}//AdminBoardDelete
	
	
	/**
	 * 	 포인트 상점 관리(추가)
	 * */
	public static boolean AdminPointInsert(PointShop point) throws SQLException{
		boolean result = dao.AdminPointInsert(point);
		if(!result) {
			throw new SQLException("포인트 상점 추가 실패");
		}//if
		return result;
	}//AdminPointInsert
	
	
	/**
	 * 	 포인트 상점 관리(수정)
	 * */
	public static boolean AdminPointUpdate(int uid, String name, String type, String stock) throws SQLException{
		boolean result = dao.AdminPointUpdate(uid, name, type, stock);
		if(!result) {
			throw new SQLException("포인트 상점 수정 실패");
		}//if
		return result;
	}//AdminPointUpdate
	
	
	/**
	 * 	 포인트 상점 관리(삭제)
	 * */
	public static boolean AdminPointDelete(int uid) throws SQLException{
		boolean result = dao.AdminPointDelete(uid);
		if(!result) {
			throw new SQLException("포인트 상점 삭제 실패");
		}//if
		return result;
	}//AdminPointDelete
	
	
}//AdminService