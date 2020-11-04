package movie.dao;

import java.sql.SQLException;

import movie.dto.UserDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public int getUserId(UserDTO user) throws SQLException {
		return 0;
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
		return false;
	}

	@Override
	public boolean updateUserLastLogin(UserDTO user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int setUserPoints(int uid, int numPoint) throws SQLException {
		return 0;
	}

	@Override
	public boolean addUserPoints(int uid, int numPoint) throws SQLException {
		return false;
	}

	@Override
	public int getUserPoints(UserDTO user) throws SQLException {
		return 0;
	}

	@Override
	public int getUserRoleId(UserDTO user) throws SQLException {
		return 0;
	}

	@Override
	public boolean setUserRoleId(UserDTO user, int roleId) throws SQLException {
		return false;
	}

	@Override
	public boolean setUserViewAdult(int uid, boolean visible) throws SQLException {
		return false;
	}

	@Override
	public boolean getUserViewAdult(UserDTO user) throws SQLException {
		return false;
	}

}
