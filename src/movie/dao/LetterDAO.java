package movie.dao;

import java.sql.SQLException;

import movie.dto.Letter;

/*
 * 쪽지 인터페이스
 */
public interface LetterDAO {

	/**
	 *	쪽지 열람 상태 확인
	 *
	 * @param	int [user_letter 테이블] u_id
	 * @return	boolean [user_letter 테이블] checked (0/1 = false/true)
	 */
	boolean getLetterChecked(int uid) throws SQLException;
	
	
	/**
	 *	쪽지 열람 상태 설정
	 *
	 * @param1	int [user_letter 테이블] u_id
	 * @param2	boolean check
	 * @return	boolean 성공 여부 (false/true)
	 */
	boolean setLetterChecked(int uid, boolean check) throws SQLException;
	
	
	/**
	 *	쪽지 전송
	 *
	 * @param1	int [userlist 테이블] u_id (전송자)
	 * @param2	int [userlist 테이블] u_id (수신자)
	 * @param3	String text
	 * @return	boolean 성공 여부 (false/true)
	 */
	boolean sendLetter(int sender_uid, int receiver_uid, String text) throws SQLException;
	
	
	/**
	 *	쪽지 상세 정보 확인
	 *
	 * @param	int [user_letter 테이블] u_id
	 * @return	Letter
	 */
	Letter getLetter(int uid) throws SQLException;
}
