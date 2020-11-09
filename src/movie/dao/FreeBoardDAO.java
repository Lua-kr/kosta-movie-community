package movie.dao;

import java.sql.SQLException;
import java.util.List;

import movie.dto.ForumThread;

public interface FreeBoardDAO {
	/**
	 * 자유게시판 전체검색
	 */
	List<ForumThread> SelectBoardAll(int categoryNum) throws SQLException;
	
	
	/**
	 * 자유게시판 작성
	 */
	int freeBoardInsert(ForumThread thread) throws SQLException;
	
	
	/**
	 * 자유게시판 수정
	 */
	int freeBoardUpdate(int authorid, String text, String title) throws SQLException;
	

	/**
	 * 자유게시판 삭제
	 */
	int freeBoardDelete(int ftid) throws SQLException;
	
	
}//FreeBoardDAO