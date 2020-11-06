package movie.dao;

import java.sql.SQLException;

import movie.dto.ForumPost;

public interface ForumPostDAO {
	/**
	 * ¥Ò±€ ¿€º∫
	 */
	int forumPostInsert(ForumPost post) throws SQLException;
	
	/**
	 * ¥Ò±€ ºˆ¡§
	 */
	int forumPostUpdate(int uid, String text) throws SQLException;
	

	/**
	 * ¥Ò±€ ªË¡¶
	 */
	int forumPostDelete(int uid) throws SQLException;
	
	
}//ForumPost