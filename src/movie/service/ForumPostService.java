package movie.service;

import java.sql.SQLException;
import java.util.List;

import movie.dao.ForumPostDAO;
import movie.dao.ForumPostDAOImpl;
import movie.dto.ForumPost;

public class ForumPostService {
	private static ForumPostDAO dao = new ForumPostDAOImpl();
	
	public static List<ForumPost> selectForumPost() throws SQLException{
		List<ForumPost> list = dao.selectForumPost();
		if(list == null) throw new SQLException("검색 실패");
		return list;
	}
	
	
	/**
	 * 댓글 작성
	 */
	public static int forumPostInsert(ForumPost post) throws SQLException{
		int result = dao.forumPostInsert(post);
		if(result == 0) throw new SQLException("");
		return result;
	}//forumPostInsert
	
	
	public static int addPost(int threadNo, int authorid, String text) throws SQLException{
		int result = dao.addPost(threadNo, authorid, text);
		if(result == 0) throw new SQLException("댓글 작성 실패");
		return result;
	}//addPost
	
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