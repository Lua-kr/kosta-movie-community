package movie.dao;

import java.sql.SQLException;

public interface BoardDAO {
	
	/**
	 * 	¸®ºä(¼öÁ¤)
	 * */
	int updateReview(int uid, int authorid, String text, String title) throws SQLException;
	
	
	/**
	 * 	¸®ºä(»èÁ¦)
	 * */
	int deleteReview(int uid, int authorid) throws SQLException;

	
}//BoardDAO