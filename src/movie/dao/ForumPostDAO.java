package movie.dao;

import java.sql.SQLException;
import java.util.List;

import movie.dto.ForumPost;

public interface ForumPostDAO {
	List<ForumPost> selectForumPost() throws SQLException;
	
	
	/**
	 * ¥Ò±€ ¿€º∫
	 */
	int forumPostInsert(ForumPost post) throws SQLException;
	
	int addPost(int threadNo, int authorid, String text) throws SQLException;
	
	/**
	 * ¥Ò±€ ºˆ¡§
	 */
	int forumPostUpdate(int uid, String text) throws SQLException;
	

	/**
	 * ¥Ò±€ ªË¡¶
	 */
	int forumPostDelete(int uid) throws SQLException;
	
	
}//ForumPost