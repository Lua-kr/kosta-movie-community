package movie.service;

import java.sql.Connection;
import java.sql.SQLException;

import movie.dao.UserDAO;
import movie.dao.UserDAOImpl;
import movie.dto.UserDTO;

public class UserService {
	private static UserDAO dao = new UserDAOImpl();
	
	/**
	 * 유저 고유 아이디 확인
	 */
	public static int getUserId(UserDTO user) throws SQLException{
		return 0;
	}

	/**
	 * 유저 로그인
	 */
	public static UserDTO userLogin(UserDTO user) throws SQLException{
		return null;
	}

	/**
	 * 회원 로그아웃
	 */
	public static boolean userLogout(UserDTO user) throws SQLException{
		return false;
	}

	/**
	 * 계정 잠금 여부 확인
	 */
	public static boolean getUserLocked(int uid) throws SQLException{
		return false;
	}

	/**
	 * 유저 마지막 로그인 날짜/IP 갱신
	 */
	public static boolean updateUserLastLogin(UserDTO user) throws SQLException{
		return false;
	}

	/**
	 * 유저 활동 포인트 설정
	 */
	public static int setUserPoints(int uid, int numPoint) throws SQLException{
		return 0;
	}

	/**
	 * 유저 활동 포인트 더하기/빼기
	 */
	public static boolean addUserPoints(Connection con, int uid, int numPoint) throws SQLException{
		return false;
	}

	/**
	 * 유저 활동 포인트 확인
	 */
	public static int getUserPoints(UserDTO user) throws SQLException{
		return 0;
	}

	/**
	 * 유저 등급 아이디 확인
	 */
	public static int getUserRoleId(UserDTO user) throws SQLException{
		return 0;
	}

	/**
	 * 유저 등급 아이디 설정
	 */
	public static boolean setUserRoleId(UserDTO user, int roleId) throws SQLException{
		return false;
	}

	/**
	 * 유저 성인 등급 열람 여부 설정
	 */
	public static boolean setUserViewAdult(int uid, boolean visible) throws SQLException{
		return false;
	}

	/**
	 * 유저 성인 등급 열람 여부 확인
	 */
	public static boolean getUserViewAdult(UserDTO user) throws SQLException{
		return false;
	}

}
