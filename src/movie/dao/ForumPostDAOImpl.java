package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie.dto.ForumPost;
import movie.util.DbUtil;

public class ForumPostDAOImpl implements ForumPostDAO {
	
	@Override
	public List<ForumPost> selectForumPost() throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		List<ForumPost> list = new ArrayList<ForumPost>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ForumPost(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	
	@Override
	public int forumPostInsert(ForumPost post) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO FORUM_POST VALEUS(?,?,?,?,?,SYSDATE)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, post.getId());
			ps.setString(2, post.getText());
			ps.setInt(3, post.getThreadId());
			ps.setInt(4, post.getAuthorId());
			ps.setInt(5, post.getVote());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps, null);
		} // finally

		return result;
	}//forumPostInsert
	
	@Override
	public int addPost(int threadNo, int authorid, String text) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO FORUM_POST VALEUS(FPID_SEQ.NEXTVAL,?,?,?,default,SYSDATE)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, text);
			ps.setInt(2, threadNo);
			ps.setInt(3, authorid);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(null, ps);
		} // finally

		return result;
	}
	

	@Override
	public int forumPostUpdate(int uid, String text) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE FORUM_POST SET TEXT = ? WHERE U_ID = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, text);
			ps.setInt(2, uid);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps, null);
		} // finally

		return result;
	}//forumPostUpdate

	@Override
	public int forumPostDelete(int uid) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FORUM_POST WHERE U_ID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}//finally
		
		return result;
	}//forumPostDelete

	




	

}//ForumPostDAOImpl