package movie.dao;

import java.sql.SQLException;
import java.util.List;

import movie.dto.ForumReview;
import movie.dto.ForumThread;

public interface BoardDAO {
	/** 리뷰 작성시 모든글테이블에 등록 */
	int insert(ForumThread forumThread) throws SQLException;

	/**
	 * 	글 카테고리
	 * */
	int selectcategory() throws SQLException;
	
	
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
	
	/**
	 * 리뷰(조회)
	 */
	List<ForumThread> selectReview(int categoryNo) throws SQLException;

	
	/**
	 * 전체 게시글 조회
	 * @param categoryNo
	 * @return
	 * @throws SQLException
	 */
	List<ForumThread> selectBoardAll(int categoryNo) throws SQLException;
	
	
	
	
	

}// BoardDAO
