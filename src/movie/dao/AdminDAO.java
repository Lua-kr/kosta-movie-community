package movie.dao;

import java.sql.SQLException;

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
	 *	
	 */
	
}//AdminDAO