package movie.dao;

import java.sql.SQLException;

import movie.dto.PointShop;
import movie.dto.UserDTO;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public boolean checkAdmin(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AdminSearch(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AdminUpdate(UserDTO user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AdminDelete(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int AdminBlackList(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean AdminBoardUpdate(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AdminBoardDelete(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AdminPointInsert(PointShop point) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AdminPointUpdate(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AdminPointDelete(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}//AdminDAOImpl