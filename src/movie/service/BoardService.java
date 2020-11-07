package movie.service;

import java.sql.SQLException;

import movie.dao.BoardDAO;
import movie.dao.BoardDAOImpl;

public class BoardService {
	private static BoardDAO dao = new BoardDAOImpl();

	/**
	 * 	 리뷰 (수정)
	 * */
	public static int updateReview(int uid, int authorid, String text, String title) throws SQLException{
		int result = dao.updateReview(uid, authorid, text, title);
		if(result == 0) { throw new SQLException("수정을 실패했습니다.");
		}
		return result;
	}
	
	/**
	 * 	 리뷰 (삭제)
	 * */
	public static int deleteReview(int uid, int authorid) throws SQLException{
		int result = dao.deleteReview(uid, authorid);
		if(result == 0) { throw new SQLException("삭제를 실패했습니다.");
		}
		return result;
	}
}