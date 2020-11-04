package movie.dao;

import java.sql.SQLException;

import movie.dto.PointShop;
import movie.dto.UserDTO;

/**
 * 관리자 인터페이스
 */
public interface AdminDAO {
	
	/**
	 *	유저의 관리자 여부 확인
	 *
	 * @param	int [userlist 테이블] u_id
	 * @return	관리자 여부 (0/1 = false/true)
	 */
	boolean checkAdmin(int uid) throws SQLException;

	
	/*
	 *	회원 정보 (검색)
	 */
	boolean AdminSearch(UserDTO user) throws SQLException;
	
	
	/*
	 *	회원 정보 (수정)
	 */
	boolean AdminUpdate(int uid, int points, String roldID) throws SQLException;
	
	
	/*
	 *	회원 정보 (삭제)
	 */
	boolean AdminDelete(int uid) throws SQLException;
	
	
	/*
	 *	회원 블랙 리스트 등록(아이디 차단)
	 */
	int AdminBlackList(int uid, int locked) throws SQLException;
	
	
	/*
	 *	게시물 (수정)
	 */
	boolean AdminBoardUpdate(int uid, String text, String title) throws SQLException;
	
	
	/*
	 *	게시물 (삭제)
	 */
	boolean AdminBoardDelete(int uid) throws SQLException;
	
	
	/**
	 * 	 포인트 상점 관리(추가)
	 * */
	boolean AdminPointInsert(PointShop point) throws SQLException;
	
	
	/**
	 * 	 포인트 상점 관리(수정)
	 * */
	boolean AdminPointUpdate(int uid, String name, String type, String stock) throws SQLException;
	
	
	/**
	 * 	 포인트 상점 관리(삭제)
	 * */
	boolean AdminPointDelete(int uid) throws SQLException;
	
	
}//AdminDAO