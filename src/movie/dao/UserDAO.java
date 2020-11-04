package movie.dao;

import java.sql.SQLException;

import java.util.List;

import movie.dto.UserDTO;


/**
 * 유저 인터페이스
 */
public interface UserDAO {
	
	/**
	 *	유저 고유 아이디 확인
	 *
	 * @param	UserDTO user
	 * @return	없을 경우 -1, 있으면 [user 테이블] uid
	 */
	int getUserId(UserDTO user) throws SQLException;
	
	
	/**
	 *	유저 로그인
	 * 
	 * @param	(미정) UserDTO user
	 * @return	(미정) access token 또는 UserDTO user
	 */
	UserDTO userLogin(UserDTO user) throws SQLException;
	
	
	/**
	 *	회원 로그아웃
	 * 
	 * TODO:	서버에 저장된 refresh token, access token 삭제
	 * 
	 * @param	UserDTO user
	 * @return	성공 여부 (true/false)
	 */
	boolean userLogout(UserDTO user) throws SQLException;
	
	
	/**
	 *	계정 잠금 여부 확인
	 * 
	 * @param	int [user 테이블] uid
	 * @return	int [user 테이블] account_locked 값 (0/1)
	 */
	boolean getUserLocked(int uid) throws SQLException;
	
	
	/**
	 *	유저 마지막 로그인 날짜/IP 갱신
	 * 
	 * @param	UserDTO user
	 * @return	성공 여부 (true/false)
	 */
	boolean updateUserLastLogin(UserDTO user) throws SQLException;
	
	
	/**
	 *	유저 활동 포인트 설정
	 * 
	 * @param1	int [user 테이블] uid
	 * @param2	int numPoint
	 * @return	[user 테이블] points (결과 값)
	 */
	int setUserPoints(int uid, int numPoint) throws SQLException;
	
	
	/**
	 *	유저 활동 포인트 더하기/빼기
	 * 
	 * @param1	int [user 테이블] uid
	 * @param2	int numPoint
	 * @return	성공 여부 (true/false)
	 */
	boolean addUserPoints(int uid, int numPoint) throws SQLException;
	
	
	/**
	 *	유저 활동 포인트 확인
	 * 
	 * @param	UserDTO uid
	 * @return	int user.points
	 */
	int getUserPoints(UserDTO user) throws SQLException;
	
	
	/**
	 *	유저 등급 아이디 확인
	 * 
	 * @param	UserDTO uid
	 * @return	int user.roleId
	 */
	int getUserRoleId(UserDTO user) throws SQLException;
	
	
	/**
	 *	유저 등급 아이디 설정
	 * 
	 * @param	UserDTO uid
	 * @param	int [user_role 테이블] uid
	 * @return	성공 여부 (true/false)
	 */
	boolean setUserRoleId(UserDTO user, int roleId) throws SQLException;
	
	
	/**
	 *	유저 성인 등급 열람 여부 설정
	 * 
	 * @param	int [user_role 테이블] uid
	 * @param	boolean visible (true/false)
	 * @return	성공 여부 (true/false)
	 */
	boolean setUserViewAdult(int uid, boolean visible) throws SQLException;
	
	
	/**
	 *	유저 성인 등급 열람 여부 확인
	 * 
	 * @param	UserDTO user
	 * @return	user.viewAdult
	 */
	boolean getUserViewAdult(UserDTO user) throws SQLException;
	
	
}//UserDAO