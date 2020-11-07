package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie.dto.ForumThread;
import movie.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insertReview(ForumThread forumThread) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into forum_thread valuese(ftid_seq.nextval,0,0,0,?,default,default,0,?,?,sysdate)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, forumThread.getAuthorId());
			ps.setString(2, forumThread.getText());
			ps.setString(3, forumThread.getTitle());

			rs = ps.executeQuery();
			while (rs.next()) {
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
	 * ¸®ºä(¼öÁ¤)
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
	 * ¸®ºä(»èÁ¦)
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
	
}// class
