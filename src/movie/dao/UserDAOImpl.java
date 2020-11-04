package movie.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie.dto.UserDTO;
import movie.util.DbUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public int getUserId(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select u_id from userlist where u_id=?";
		int result = -1;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUid());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public UserDTO userLogin(UserDTO user) throws SQLException {
		return null;
	}

	@Override
	public boolean userLogout(UserDTO user) throws SQLException {
		return false;
	}

	@Override
	public boolean getUserLocked(int uid) throws SQLException {
		 Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      boolean result = false;
	      String sql = "SELECT ACCOUNT_LOCKED FROM USERLIST WHERE U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, uid);
	         rs = ps.executeQuery();
	         result = rs.getBoolean(1);
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }//finally
	      return result;
	}

	@Override
	public boolean updateUserLastLogin(UserDTO user) throws SQLException {
		 Connection con = null;
	      PreparedStatement ps = null;
	      boolean result = false;
	      String sql = "UPDATE USERLIST SET LAST_UPDATE_DATE = SYSDATE AND LAST_UPDATE_IP = ? WHERE U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, user.getUid());
	         ps.executeUpdate();
	         result = true;
	      }catch (Exception e) {
	         return result;
	      }finally {
	         DbUtil.dbClose(con, ps, null);
	      }//finally
	      return result;
	}

	@Override
	public int setUserPoints(int uid, int numPoint) throws SQLException {
		Connection con = null;
	      PreparedStatement ps = null;
	      int result = 0;
	      String sql = "UPDATE USERLIST SET POINTS = ? WHERE U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, numPoint);
	         ps.setInt(2, uid);
	         result = ps.executeUpdate();
	      }finally {
	         DbUtil.dbClose(con, ps, null);
	      }//finally
	      return result;
	}

	@Override
	public boolean addUserPoints(Connection con, int uid, int numPoint) throws SQLException {
		PreparedStatement ps = null;
		String sql = "update userlist set point= point+? where u_id=?";
		boolean result = false;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, numPoint);
			ps.setInt(2, uid);
			if (ps.executeUpdate() != 0) {
				result = true;
			}
		} finally {
			DbUtil.dbClose(null, ps, null);
		}
		return result;
	}

	@Override
	public int getUserPoints(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select points from userlist where u_id=?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUid());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public int getUserRoleId(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select  ROLE_ID from userlist where u_id=?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getRoleId());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	public boolean setUserRoleId(UserDTO user, int roleId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "UPDATE USERLIST SET ROLE_ID = ? WHERE = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, roleId);
			if (ps.executeUpdate() != 0) {
				result = true;
			}
		} finally {
			DbUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	public boolean setUserViewAdult(int uid, boolean visible) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "UPDATE USERLIST SET VIEW_ADLUT = ? WHERE U_ID = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setBoolean(1, visible);
			if (ps.executeUpdate() != 0) {
				result = true;
			}
		} finally {
			DbUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	public boolean getUserViewAdult(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select view_adult from userlist where u_id=?";
		boolean result = false;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUid());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getBoolean(1);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

}
