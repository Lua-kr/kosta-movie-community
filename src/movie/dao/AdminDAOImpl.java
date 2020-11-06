package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie.dto.Admin;
import movie.dto.PointShop;
import movie.dto.UserDTO;
import movie.util.DbUtil;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public boolean checkAdmin(int uid) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		Admin dto = new Admin();
		String sql = "SELECT * FROM USER_ADMIN WHERE U_ID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new Admin(rs.getInt(1), rs.getInt(2));
			}//if
			
			result = true;
		}catch(Exception e){
			result = false;
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}//finally
		
		return result;
	}//checkAdmin

	@Override
	   public boolean AdminSearch(UserDTO user) throws SQLException {
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      boolean result = false;
	      String sql = "select * from USERLIST";
	      UserDTO userdto = null;
	      try {
	         //연결 실행
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         
	         rs=ps.executeQuery();
	         while(rs.next()) {
	            int uid = rs.getInt(1); // 고유 유저 번호
	            String name = rs.getString(2); // 닉네임
	            String email = rs.getString(3);// 메일
	            String ip = rs.getString(4);// 아이피
	            String creDate =rs.getString(5); // 가입일
	            String lock = rs.getString(6); // 아이피 밴 유무
	            String lastDate = rs.getString(7); // 마지막접속일
	            String lastIp = rs.getString(8); // 마지막 접속 아이피
	            int point = rs.getInt(9); // 활동 포인트
	            int roleId = rs.getInt(10); // 등급 번호
	            boolean viewAdult = rs.getBoolean(11); // 성인 등급 열람 여부
	            
	            userdto = new UserDTO(uid, name, email, ip, creDate, lock, lastDate, lastIp, point, roleId, viewAdult);
	            result = true;
	         }//while
	      }catch (Exception e) {
	         result = false;
	      }finally {
	         DbUtil.dbClose(con, ps, rs);
	      }//finally
	      return result;
	   }//AdminSearch

	 @Override
	   public boolean AdminDelete(int uid) throws SQLException {
	      Connection con = DbUtil.getConnection();
	      PreparedStatement ps =null;
	      boolean result = false;
	      try{
	         ps = con.prepareStatement("delete userlist where U_ID=? ");
	         ps.setInt(1, uid);
	         
	         ps.executeUpdate();
	         result = true;
	      }catch (Exception e) {
	         result = false;
	      }finally{
	         DbUtil.dbClose(con, ps, null);
	      }//finally
	      
	      return result;
	   }//AdminDelete
	    

	 @Override
	   public int AdminBlackList(int uid, int locked) throws SQLException {
	      Connection con = null;
	      PreparedStatement ps = null;
	      int result = 0;
	      
	      String sql = "update userlist set ACCOUNT_LOCKED=? where uid=?";
	            
	      try {
	         con = movie.util.DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         
	         ps.setInt(1, locked);
	         ps.setInt(2, uid);

	         result = ps.executeUpdate();
	      }finally {
	         DbUtil.dbClose(con, ps, null);
	      }//finally
	         return result;
	   }//AdminBlackList

	@Override
	public boolean AdminBoardUpdate(int uid, String text, String title) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "UPDATE FORUM_THREAD SET TEXT = ? AND TITLE = ? WHERE U_ID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, text);
			ps.setString(2, title);
			ps.setInt(3, uid);
			
			ps.executeUpdate();
			result = true;
		}catch(Exception e){
			result = false;
		}finally {
			DbUtil.dbClose(con, ps);
		}//finally
		
		return result;
	}//AdminBoardUpdate

	@Override
	public boolean AdminBoardDelete(int uid) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "DELETE FROM FORUM_THREAD WHERE U_ID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ps.executeUpdate();
			result = true;
		}catch(Exception e){
			result = false;
		}finally {
			DbUtil.dbClose(con, ps);
		}//finally
		
		return result;
	}//AdminBoardDelete

	@Override
	public boolean AdminPointInsert(PointShop point) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "INSERT INTO VALUES POINT_SHOP(?,?,?,?,?,?,?,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, point.getId());
			ps.setString(2, point.getName());
			ps.setString(3, point.getType());
			ps.setInt(4, point.getPoint());
			ps.setInt(5, point.getStock());
			ps.setInt(6, point.getLocked());
			ps.setInt(7, point.getFileId());
			ps.setInt(8, point.getReqRoldId());
			
			ps.executeUpdate();
			result = true;
		}catch(Exception e) {
			result = false;
		}finally {
			DbUtil.dbClose(con, ps);
		}//finally
		
		return result;
	}//AdminPointInsert

	@Override
	public boolean AdminPointUpdate(int uid, String name, String type, String stock) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "UPDATE POINT_SHOP SET ITEM_NAME = ? AND ITEM_TYPE = ? AND ITEM_STOCK = ? WHERE U_ID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, type);
			ps.setString(3, stock);
			ps.setInt(4, uid);
			
			ps.executeUpdate();
			result = true;
		}catch(Exception e) {
			result = false;
		}finally {
			DbUtil.dbClose(con, ps);
		}//finally
		
		return result;
	}//AdminPointUpdate

	@Override
	public boolean AdminPointDelete(int uid) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "DELETE FROM POINT_SHOP WHERE U_ID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ps.executeUpdate();
			result = true;
		}catch(Exception e) {
			result = false;
		}finally {
			DbUtil.dbClose(con, ps);
		}//finally
		
		return result;
	}//AdminPointDelete

}//AdminDAOImpl