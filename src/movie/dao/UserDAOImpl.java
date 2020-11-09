package movie.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import movie.dto.Letter;
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
	public boolean isUserLocked(int uid) throws SQLException {
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
	         if (rs.next()) result = rs.getBoolean(1);
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
	      String sql = "UPDATE USERLIST SET LAST_UPDATE_DATE = SYSDATE, LAST_UPDATE_IP = ? WHERE U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setString(1, user.getLastIp());
	         ps.setInt(2, user.getUid());
	         result = (ps.executeUpdate() != 0);
	      }catch (Exception e) {
	    	  e.printStackTrace();
	      }finally {
	         DbUtil.dbClose(con, ps, null);
	      }//finally
	      return result;
	}

	@Override
	public boolean setUserPoints(int uid, int numPoint) throws SQLException {
		Connection con = null;
	      PreparedStatement ps = null;
	      boolean result = false;
	      String sql = "UPDATE USERLIST SET POINTS = ? WHERE U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, numPoint);
	         ps.setInt(2, uid);
	         result = (ps.executeUpdate() != 0);
	      }finally {
	         DbUtil.dbClose(con, ps, null);
	      }//finally
	      return result;
	}

	/**
	 * 유저 활동 포인트 더하기/빼기
	 */
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
			result = (ps.executeUpdate() != 0);
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
			result = (ps.executeUpdate() != 0);
		} finally {
			DbUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	public boolean setUserAgeAdult(int uid, boolean isAdult) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "UPDATE USERLIST SET AGE_ADULT = ? WHERE U_ID = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, isAdult?1:0);
			ps.setInt(2, uid);
			result = (ps.executeUpdate() != 0);
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
		String sql = "UPDATE USERLIST SET VIEW_ADULT = ? WHERE U_ID = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, visible?1:0);
			ps.setInt(2, uid);
			result =  (ps.executeUpdate() != 0);
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

	@Override
	public int getUserNotification(int u_id) throws SQLException {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int numAlarms = 0;
	      String sql = "select count(*) from NOTIFICATION where checked = 0 and RECEIVER_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, u_id);
	         
	         rs=ps.executeQuery();
	         if(rs.next()) {
	            numAlarms = rs.getInt(1);
	         }
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }
	      return numAlarms;

	}

	@Override
	public String getUserFirstIP(int u_id) throws SQLException {
		 Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      String ip = null;
	      String sql = "select CREATED_IP from USERLIST where U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, u_id);
	         
	         rs=ps.executeQuery();
	         if (rs.next()) {
	            ip = rs.getString(1);
	         }
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }
	      return ip;

	}

	@Override
	public String getUserLastIP(int u_id) throws SQLException {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      String lastIp = null;
	      String sql = "select LAST_UPDATE_IP from USERLIST where U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, u_id);
	         
	         rs=ps.executeQuery();
	         if (rs.next()) {
	            lastIp = rs.getString(1);
	         }
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }
	      return lastIp;

	}

	@Override
	public String getUserFirstDate(int uid) throws SQLException {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      String sql = "select created_date from userlist where u_id = ?";
	      String date=null;
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, uid);
	         rs = ps.executeQuery();
	         if(rs.next()) {
	            date = rs.getString(1);
	         }
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }
	      return date;

	}

	@Override
	public String getUserLastDate(int uid) throws SQLException {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      String sql = "select last_update_date from userlist where u_id = ?";
	      String date=null;
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, uid);
	         rs = ps.executeQuery();
	         if(rs.next()) {
	            date = rs.getString(1);
	         }
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }
	      return date;
	}

	@Override
	public List<Letter> getUserLetterList(int uid) throws SQLException {
		Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      List<Letter> list = new ArrayList<Letter>();
	      String sql = "select * from USER_LETTER where RECEIVER_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, uid);
	         
	         rs=ps.executeQuery();
	         while(rs.next()) {
	            uid = rs.getInt(1);
	            int sender_uid = rs.getInt(2);
	            int receiver_uid = rs.getInt(3);
	            String text = rs.getString(4);
	            String timedate = rs.getString(5);
	            boolean checked = rs.getBoolean(6);
	            
	            Letter letter = new Letter(uid, sender_uid, receiver_uid, text, timedate, checked);
	            list.add(letter);
	         }
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }
	      return list;
	}

	@Override
	public boolean setUserLock(int uid, boolean lock) throws SQLException {
		 Connection con = null;
	      PreparedStatement ps = null;
	      boolean result=false;
	      String sql = "update userlist set  ACCOUNT_LOCKED = ? where u_id = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, lock?1:0);
	         ps.setInt(2, uid);
	         result = (ps.executeUpdate() != 0);
	      }finally {
	         DbUtil.dbClose(con, ps, null);
	      }
	      return result;
	}

	@Override
	public boolean updateUserNickname(int uid, String nickname) throws SQLException {
		
		  Connection con = null;
	      PreparedStatement ps = null;
	      boolean result = false;
	      String sql = "UPDATE USERLIST SET NICKNAME = ? WHERE U_ID = ?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setString(1,nickname);
	         ps.setInt(2,uid);
	         result = (ps.executeUpdate() != 0);
	      }catch (Exception e) {
	    	  e.printStackTrace();
	      }finally {
	         DbUtil.dbClose(con, ps, null);
	      }//finally
	      return result;
	}

	@Override
	public UserDTO getUserInfo(int uid, HttpSession session) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from userlist where u_id = ?";
		UserDTO userInfo = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			if (rs.next()) {
									// 1UID, 2ROLE_ID, 3NICKNAME, 4EMAIL, 5CREATED_IP, 6CREATED_DATE, 7ACCOUNT_LOCKED, 8LAST_UPDATE_DATE, 9LAST_UPDATE_IP, 10POINTS, 11VIEW_ADULT, 12AGE_ADULT
				userInfo = new UserDTO(uid, rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), (rs.getInt(7) != 0), rs.getString(8), rs.getString(9), rs.getInt(10), (rs.getInt(11) != 0), (rs.getInt(12) != 0), session);
				System.out.println("User Load: " + uid);
			} else if (session != null) { // 로그인 하였으나 DB가 없으므로 최초 생성
				System.out.println("New User: " + uid);
				ps.close();
				rs.close();
				sql = "insert into userlist(U_ID, NICKNAME, EMAIL, CREATED_IP, CREATED_DATE, LAST_UPDATE_DATE, LAST_UPDATE_IP) values(?, ?, ?, ?, sysdate, sysdate, ?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, uid);
				ps.setString(2, (String)session.getAttribute("nickname"));
				ps.setString(3, (String)session.getAttribute("email"));
				String ip = (String)session.getAttribute("ip");
				ps.setString(4, ip);
				ps.setString(5, ip);
				if (ps.executeUpdate() > 0) userInfo = getUserInfo(uid, session);
//				rs = ps.getGeneratedKeys();
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return userInfo;
	}
}
