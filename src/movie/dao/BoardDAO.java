package movie.dao;

import java.sql.SQLException;

import movie.dto.ForumThread;

public interface BoardDAO {
	/** 리뷰 작성시 모든글테이블에 등록 */
	int insertReview(ForumThread forumThread) throws SQLException;

	/** 리뷰테이블 등록 */
	int addReview(int threadNo, String movieId, String rate) throws SQLException;

	/**
	 * 리뷰(수정)
	 */
	int updateReview(int uid, int authorid, String text, String title) throws SQLException;

	/**
	 * 리뷰(삭제)
	 */
	int deleteReview(int uid, int authorid) throws SQLException;

}// BoardDAO