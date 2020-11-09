package movie.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie.dto.ForumReview;
import movie.dto.ForumThread;
import movie.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insert(ForumThread forumThread) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into forum_thread values(ftid_seq.nextval,0,0,0,?,default,default,0,?,?,sysdate)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, forumThread.getAuthorId());
			ps.setString(2, forumThread.getText());
			ps.setString(3, forumThread.getTitle());

			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}// insertReview

	@Override
	public int addReview(int threadNo, String movieId, String rate) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into forum_review values(?,frid_seq.nextval,?,?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, threadNo);
			ps.setInt(2, Integer.parseInt(movieId));
			ps.setInt(3, Integer.parseInt(rate));
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(null, ps);
		}
		return result;
	}// addReview

	/**
	 * 리뷰(수정)
	 */
	@Override
	public int updateReview(int uid, int authorid, String text, String title) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = con.prepareStatement("update forum_thread set text = ?, title =?" + "where uid = ? and author_id = ?");

			ps.setString(1, text);
			ps.setString(2, title);
			ps.setInt(3, uid);
			ps.setInt(4, authorid);

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}//updateReview

	/**
	 * 리뷰(삭제)
	 */
	@Override
	public int deleteReview(int uid, int authorid) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement("delete forum_thread where uid=? and author_id=?");
			ps.setInt(1, uid);
			ps.setInt(2, authorid);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}//deleteReview

	/**
	 * 리뷰(조회)
	 */
	@Override
	public List<ForumThread> selectReview(int categoryNo) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ForumThread> list = new ArrayList<ForumThread>();
		String sql = "select t.* , r.movie_id,r.RATE from forum_thread t ,FORUM_REVIEW where t.u_id =r.THREAD_ID and t.FORUM_CATEGORY_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,categoryNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ForumThread forumthread= new ForumThread(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
				list.add(forumthread);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}//deleteReview
	
	@Override
	public int selectcategory() throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT U_ID FROM FORUM_CATEGORY";
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}//if
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}//finally
		
		return result;
	}//selectcategory
	

	/**
	 * 전체 게시글 조회
	 */
	@Override
	public List<ForumThread> selectBoardAll(int categoryNo) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ForumThread> list = new ArrayList<ForumThread>();
		String sql = "select * from forum_thread where forum_category_id = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,categoryNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ForumThread forumthread= new ForumThread(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
				list.add(forumthread);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
}// class
