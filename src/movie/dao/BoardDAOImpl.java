package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import movie.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	
	/**
	 * 	¸®ºä(¼öÁ¤)
	 * */
	@Override
	public int updateReview(int uid, int authorid, String text, String title) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		
		try{
			ps = con.prepareStatement("update forum_thread set text = ?, title =?"
								      + "where uid = ? and author_id = ?");
			
			ps.setString(1, text);
			ps.setString(2, title);
			ps.setInt(3, uid);
			ps.setInt(4, authorid);
			
			result = ps.executeUpdate();
			
		}finally{
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 	¸®ºä(»èÁ¦)
	 * */
	@Override
	public int deleteReview(int uid, int authorid) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try{
			ps = con.prepareStatement("delete forum_thread where uid=? and author_id=?");
			ps.setInt(1, uid);
			ps.setInt(2, authorid);
			result = ps.executeUpdate();
		}finally{
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
}
