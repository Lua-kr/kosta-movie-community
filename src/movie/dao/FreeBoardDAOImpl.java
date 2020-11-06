package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import movie.dto.ForumThread;
import movie.util.DbUtil;

public class FreeBoardDAOImpl implements FreeBoardDAO {

	@Override
	public int freeBoardInsert(ForumThread thread) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO FORUM_THREAD VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, thread.getFtId());
			ps.setInt(2, thread.getCountPost());
			ps.setInt(3, thread.getCountPost());
			ps.setInt(4, thread.getAuthorId());
			ps.setInt(5, thread.getThreadLocked());
			ps.setInt(6, thread.getVote());
			ps.setInt(7, thread.getPostLocked());
			ps.setString(8, thread.getText());
			ps.setString(9, thread.getTitle());
			ps.setString(10, thread.getTimeDate());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps, null);
		} // finally

		return result;
	}//freeBoardInsert

	@Override
	public int freeBoardUpdate(int authorid, String text, String title) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE FORUM_THREAD SET TEXT = ? AND TITLE = ? WHERE AUTHOR_ID = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, text);
			ps.setString(2, title);
			ps.setInt(3, authorid);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps, null);
		} // finally

		return result;
	}//freeBoardUpdate

	@Override
	public int freeBoardDelete(int ftid) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FORUM_THREAD WHERE U_ID = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ftid);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps, null);
		} // finally

		return result;
	}//freeBoardDelete

}//FreeBoardDAOImpl