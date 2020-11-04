package movie.dao;

import java.sql.Connection;
import java.sql.SQLException;

import movie.dto.UserDTO;


/**
 * 유저 인터페이스
 */
public interface UserDAO {
	
	/**
	 *	유저 고유 아이디 확인
	 *
	 * @param	UserDTO user
	 * @return	없을 경우 -1, 있으면 [userlist 테이블] u_id
	 */
	int getUserId(UserDTO user) throws SQLException;
	
	
	/**
	 *	유저 로그인
	 *
	 *	TODO:	(로그인 API 기능 구현 후 인수와 리턴 정의)
	 * 
	 * @param	(미정) UserDTO user
	 * @return	(미정) access token 또는 UserDTO user
	 */
	UserDTO userLogin(UserDTO user) throws SQLException;
	
	
	/**
	 *	회원 로그아웃
	 * 
	 * TODO:	(서버에 저장된 refresh token, access token 삭제)
	 * 
	 * @param	UserDTO user
	 * @return	성공 여부 (true/false)
	 */
	boolean userLogout(UserDTO user) throws SQLException;
	
	
	/**
	 *	계정 잠금 여부 확인
	 * 
	 * @param	int [userlist 테이블] u_id
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
	 * @param1	int [userlist 테이블] u_id
	 * @param2	int numPoint
	 * @return	[user 테이블] points (결과 값)
	 */
	int setUserPoints(int uid, int numPoint) throws SQLException;
	
	
	/**
	 *	유저 활동 포인트 더하기/빼기
	 *
	 *	@apiNote	유저가 활동하여 포인트 변동이 있는 메소드에서 쓰이는 전용 (해당 메소드의 Connection con 요구)
	 * 
	 * @param1	Connection con
	 * @param2	int [userlist 테이블] u_id
	 * @param3	int numPoint
	 * @return	성공 여부 (true/false)
	 */
	boolean addUserPoints(Connection con, int uid, int numPoint) throws SQLException;
	
	
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
	 * @param	int [user_role 테이블] u_id
	 * @return	성공 여부 (true/false)
	 */
	boolean setUserRoleId(UserDTO user, int roleId) throws SQLException;
	
	
	/**
	 *	유저 성인 등급 열람 여부 설정
	 * 
	 * @param	int [user_role 테이블] u_id
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
	
	
	/**
	 * 	유저 쪽지 전체 목록 불러오기
	 * 
	 *	TODO:	(return 정의 필요, json 또는 list)
	 * 
	 * @param	int [userlist 테이블] u_id
	 * @return	(미정) Json or List<Letter> letterList
	 */
	void getUserLetterList(int uid) throws SQLException; // TODO: return 정의
	
	
	/**
	 *	유저 알람 확인
	 *
	 *	@apiNote	[user_letter 테이블] receiver_id 컬럼을 [userlist 테이블] u_id 참조하여
	 *				[user_letter 테이블] checked 값이 0 인 컬럼의 수를 확인
	 *
	 * @param	int [userlist 테이블] u_id
	 * @return	int numAlarms
	 */
	int getUserNotification(int u_id) throws SQLException;
	
	
	/**
	 * 	유저 가입 당시 아이피 확인
	 * 
	 * @param	[userlist 테이블] u_id
	 * @return	String ip
	 */
	String getUserFirstIP(int u_id) throws SQLException;
	
	
	/**
	 * 	유저 마지막 로그인 아이피 확인
	 * 
	 * @param	[userlist 테이블] u_id
	 * @return	String ip
	 */
	String getUserLastIP(int u_id) throws SQLException;
	
	
	/**
	 * 	유저 가입 당시 날짜 확인
	 * 
	 * @param	[userlist 테이블] u_id
	 * @return	String date
	 */
	String getUserFirstDate(int u_id) throws SQLException;
	
	
	/**
	 * 	유저 마지막 로그인 날짜 확인
	 * 
	 * @param	[userlist 테이블] u_id
	 * @return	String date
	 */
	String getUserLastDate(int u_id) throws SQLException;
	
	
}//UserDAO