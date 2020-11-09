package movie.service;

import java.sql.SQLException;
import java.util.List;

import movie.dao.FreeBoardDAO;
import movie.dao.FreeBoardDAOImpl;
import movie.dto.ForumThread;

public class FreeBoardService {
	private static FreeBoardDAO dao = new FreeBoardDAOImpl();
	
	public static List<ForumThread> SelectFreeBoard(int categoryNum) throws SQLException{
		List<ForumThread> list = dao.SelectBoardAll(categoryNum);
		if(list == null) throw new SQLException("검색실패");
		return list;
	}
	
	/**
	 * 자유게시판 작성
	 */
	public static int freeBoardInsert(ForumThread thread) throws SQLException{
		int result = dao.freeBoardInsert(thread);
		if(result == 0) throw new SQLException("자유게시판 작성 실패");
		return result;
	}//freeBoardInsert
	
	/**
	 * 자유게시판 수정
	 */
	public static int freeBoardUpdate(int id, String text, String title) throws SQLException{
		int result = dao.freeBoardUpdate(id, text, title);
		if(result == 0) throw new SQLException("자유게시판 수정 실패");
		return result;
	}//freeBoardUpdate
	

	/**
	 * 자유게시판 삭제
	 */
	public static int freeBoardDelete(int ftid) throws SQLException{
		int result = dao.freeBoardDelete(ftid);
		if(result == 0) throw new SQLException("자유게시판 삭제 실패");
		return result;
	}//freeBoardDelete
	
	
}//FreeBoardService