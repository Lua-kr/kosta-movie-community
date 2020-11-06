package movie.service;

import java.sql.SQLException;

import movie.dao.ForumPostDAO;
import movie.dao.ForumPostDAOImpl;
import movie.dto.ForumPost;

public class ForumPostService {
	private static ForumPostDAO dao = new ForumPostDAOImpl();
	
	/**
	 * 댓글 작성
	 */
	public static int forumPostInsert(ForumPost post) throws SQLException{
		int result = dao.forumPostInsert(post);
		if(result == 0) throw new SQLException("댓글 작성 실패");
		return result;
	}//forumPostInsert
	
	/**
	 * 댓글 수정
	 */
	public static int forumPostUpdate(int uid, String text) throws SQLException{
		int result = dao.forumPostUpdate(uid, text);
		if(result == 0) throw new SQLException("댓글 수정 실패");
		return result;
	}//forumPostUpdate
	

	/**
	 * 댓글 삭제
	 */
	public static int forumPostDelete(int uid) throws SQLException{
		int result = dao.forumPostDelete(uid);
		if(result == 0) throw new SQLException("댓글 삭제 실패");
		return result;
	}//forumPostDelete
	
	
}//ForumPostService