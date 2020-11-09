package movie.service;

import java.sql.SQLException;

import movie.dao.BoardDAO;
import movie.dao.BoardDAOImpl;
<<<<<<< HEAD

public class BoardService {
	private static BoardDAO dao = new BoardDAOImpl();

	/**
	 * 	 리뷰 (수정)
	 * */
	public static int updateReview(int uid, int authorid, String text, String title) throws SQLException{
		int result = dao.updateReview(uid, authorid, text, title);
		if(result == 0) { throw new SQLException("수정을 실패했습니다.");
		}
		return result;
	}
	
	/**
	 * 	 리뷰 (삭제)
	 * */
	public static int deleteReview(int uid, int authorid) throws SQLException{
		int result = dao.deleteReview(uid, authorid);
		if(result == 0) { throw new SQLException("삭제를 실패했습니다.");
		}
		return result;
	}
}
=======
import movie.dto.ForumThread;

public class BoardService {
	BoardDAO dao = new BoardDAOImpl();

	/**리뷰작성시 전체글에 추가*/
	public int insert(ForumThread forumThread)throws SQLException {
		int result = dao.insert(forumThread);
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

	   
	   /**
	    * 	카테고리
	    * */
	   public int selectcategory() throws SQLException{
		   int result = dao.selectcategory();
		   
		   return result;
	   }//selectcategory
	   
	   
	   
	   
	

}//class
>>>>>>> branch 'master' of https://github.com/Lua-kr/kosta-movie-community.git
