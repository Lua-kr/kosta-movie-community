package movie.service;

import java.sql.SQLException;

import movie.dao.ForumPostDAO;
import movie.dao.ForumPostDAOImpl;
import movie.dto.ForumPost;

public class ForumPostService {
	private static ForumPostDAO dao = new ForumPostDAOImpl();
	
	/**
	 * ¥Ò±€ ¿€º∫
	 */
	public static int forumPostInsert(ForumPost post) throws SQLException{
		int result = dao.forumPostInsert(post);
		if(result == 0) throw new SQLException("");
		return result;
	}//forumPostInsert
	
	
	public static int addPost(int threadNo, int authorid, String text) throws SQLException{
		int result = dao.addPost(threadNo, authorid, text);
		if(result == 0) throw new SQLException("¥Ò±€ ¿€º∫ Ω«∆–");
		return result;
	}//addPost
	
	/**
	 * ¥Ò±€ ºˆ¡§
	 */
	public static int forumPostUpdate(int uid, String text) throws SQLException{
		int result = dao.forumPostUpdate(uid, text);
		if(result == 0) throw new SQLException("¥Ò±€ ºˆ¡§ Ω«∆–");
		return result;
	}//forumPostUpdate
	

	/**
	 * ¥Ò±€ ªË¡¶
	 */
	public static int forumPostDelete(int uid) throws SQLException{
		int result = dao.forumPostDelete(uid);
		if(result == 0) throw new SQLException("¥Ò±€ ªË¡¶ Ω«∆–");
		return result;
	}//forumPostDelete
	
	
}//ForumPostService