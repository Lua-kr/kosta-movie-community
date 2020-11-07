package movie.service;

import java.sql.SQLException;

import movie.dao.BoardDAO;
import movie.dao.BoardDAOImpl;
import movie.dto.ForumThread;

public class BoardSerice {
	BoardDAO dao = new BoardDAOImpl();

	/**리뷰작성시 전체글에 추가*/
	public int insertReview(ForumThread forumThread)throws SQLException {
		int result = dao.insertReview(forumThread);
				if(result<=0) {
					throw new SQLException("글 등록 실패");
				}
				return result;
	}//insertReview
	
	/**리뷰테이블에 추가*/
	public int addReview(int threadNo, String movieId, String rate)throws SQLException {
		int result =dao.addReview(threadNo,movieId,rate);
		if(result==0) {
			throw new SQLException("리뷰 등록 실패");
		}
		return result;
	}//addReview
	
	/**
	    *     리뷰 (수정)
	    * */
	   public  int updateReview(int uid, int authorid, String text, String title) throws SQLException{
	      int result = dao.updateReview(uid, authorid, text, title);
	      if(result == 0) { throw new SQLException("수정을 실패했습니다.");
	      }
	      return result;
	   }//updateReview
	   
	   /**
	    *     리뷰 (삭제)
	    * */
	   public  int deleteReview(int uid, int authorid) throws SQLException{
	      int result = dao.deleteReview(uid, authorid);
	      if(result == 0) { throw new SQLException("삭제를 실패했습니다.");
	      }
	      return result;
	   }//deleteReview
	

}//class
