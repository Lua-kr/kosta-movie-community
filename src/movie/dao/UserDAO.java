package movie.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import movie.dto.Letter;
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
	 *	유저 고유 아이디로 유저 클래스 확인
	 *
	 * @param1	int [userlist 테이블] u_id
	 * @param2	HttpSession session (로그인 할 때만 값을 주고 그 외에는 null)
	 * @return	null 또는 UserDTO 클래스
	 */
	UserDTO getUserInfo(int uid, HttpSession session) throws SQLException;
	
	
	/**
	 *	계정 잠금 여부 확인
	 * 
	 * @param	int [userlist 테이블] u_id
	 * @return	boolean [user 테이블] account_locked 값 (0/1 = false/true)
	 */
	boolean isUserLocked(int uid) throws SQLException;
	
	
	/**
	 *	유저 마지막 로그인 날짜/IP 갱신
	 * 
	 * @param	UserDTO user
	 * @return	boolean 성공 여부 (false/true)
	 */
	boolean updateUserLastLogin(UserDTO user) throws SQLException;
	
	
	/**
	 *	유저 활동 포인트 설정
	 * 
	 * @param1	int [userlist 테이블] u_id
	 * @param2	int numPoint
	 * @return	boolean 성공 여부 (false/true)
	 */
	boolean setUserPoints(int uid, int numPoint) throws SQLException;
	
	
	/**
	 *	유저 활동 포인트 더하기/빼기
	 *
	 *	@apiNote	유저가 활동하여 포인트 변동이 있는 메소드에서 쓰이는 전용 (해당 메소드의 Connection con 요구)
	 * 
	 * @param1	Connection con
	 * @param2	int [userlist 테이블] u_id
	 * @param3	int numPoint
	 * @return	boolean 성공 여부 (false/true)
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
	 *	유저 닉네임 갱신
	 *
	 * @param	UserDTO uid
	 * @return	성공 여부 (false/true)
	 */
	boolean updateUserNickname(int uid, String nickname) throws SQLException;
	
	
	/**
	 *	유저 등급 아이디 설정
	 * 
	 * @param	UserDTO uid
	 * @param	int [user_role 테이블] u_id
	 * @return	boolean 성공 여부 (false/true)
	 */
	boolean setUserRoleId(UserDTO user, int roleId) throws SQLException;
	
	
	/**
	 *	유저 성인 등급 열람 여부 설정
	 * 
	 * @param	int [user_role 테이블] u_id
	 * @param	boolean visible (false/true)
	 * @return	boolean 성공 여부 (false/true)
	 */
	boolean setUserViewAdult(int uid, boolean visible) throws SQLException;
	
	
	/**
	 *	유저 성인 등급 열람 여부 확인
	 * 
	 * @param	UserDTO user
	 * @return	boolean user.viewAdult
	 */
	boolean getUserViewAdult(UserDTO user) throws SQLException;
	
	
	/**
	 * 	유저 쪽지 전체 목록 불러오기
	 * 
	 * @param	int [userlist 테이블] u_id
	 * @return	List<Letter>
	 */
	List<Letter> getUserLetterList(int uid) throws SQLException;
	
	
	/**
	 *	유저 알람 확인
	 *
	 *	@apiNote	[notification 테이블] receiver_id 컬럼을 [userlist 테이블] u_id 참조하여
	 *				[noification 테이블] checked 값이 0 인 컬럼의 수를 확인
	 *
	 * @param	int [userlist 테이블] u_id
	 * @return	int numAlarms
	 */
	int getUserNotification(int uid) throws SQLException;
	
	
	/**
	 * 	유저 가입 당시 아이피 확인
	 * 
	 * @param	int [userlist 테이블] u_id
	 * @return	String ip
	 */
	String getUserFirstIP(int uid) throws SQLException;
	
	
	/**
	 * 	유저 마지막 로그인 아이피 확인
	 * 
	 * @param	int [userlist 테이블] u_id
	 * @return	String ip
	 */
	String getUserLastIP(int uid) throws SQLException;
	
	
	/**
	 * 	유저 가입 당시 날짜 확인
	 * 
	 * @param	int [userlist 테이블] u_id
	 * @return	String date
	 */
	String getUserFirstDate(int uid) throws SQLException;
	
	
	/**
	 * 	유저 마지막 로그인 날짜 확인
	 * 
	 * @param	int [userlist 테이블] u_id
	 * @return	String date
	 */
	String getUserLastDate(int uid) throws SQLException;
	
	
	/**
	 *	계정 잠금
	 *
	 * @param1	int [userlist 테이블] u_id
	 * @param2	boolean false/true
	 * @return	성공 여부 (false/true)
	 */
	boolean setUserLock(int uid, boolean lock) throws SQLException;


	/**
	 *	유저 성인 나이 여부 설정
	 * @param uid
	 * @param isAdult
	 * @return
	 * @throws SQLException
	 */
	boolean setUserAgeAdult(int uid, boolean isAdult) throws SQLException;
	
	
}//UserDAO