package movie.dao;

import java.sql.SQLException;

/**
 * 쪽지 인터페이스
 */
public interface LetterDAO {

	/**
	 *	쪽지 내용 확인
	 * 
	 *	@param	int [user_letter 테이블] uid
	 *	@return	String text
	 */
	String getLetterText(int uid) throws SQLException;
}
