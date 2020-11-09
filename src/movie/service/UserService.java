package movie.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.controller.ModelAndView;
import movie.dao.UserDAO;
import movie.dao.UserDAOImpl;
import movie.dto.Letter;
import movie.dto.UserDTO;

public class UserService {
	private static UserDAO dao = new UserDAOImpl();

	/**
	 * 유저 고유 아이디 확인
	 */
	public static int getUserId(UserDTO user) throws SQLException {
		int uid = dao.getUserId(user);
		if (uid == -1) {
			throw new SQLException("유저 고유 아이디가 없습니다");
		}
		return uid;
	}

	
	/**
	 *	유저 고유 아이디로 유저 클래스 확인
	 *
	 * @param	int [userlist 테이블] u_id, HttpSession session (로그인 때를 제외하고는 null 사용)
	 * @return	UserDTO 클래스
	 */
	public static UserDTO getUserInfo(int uid, HttpSession session) throws SQLException{
		UserDTO userInfo = dao.getUserInfo(uid, session);
		if (userInfo == null) {
			throw new SQLException("해당하는 유저 고유 정보가 없으며 생성에 실패하였습니다");
		}
		return userInfo;
	}

	
	/**
	 * 계정 잠금 여부 확인
	 */
	public static boolean isUserLocked(int uid) throws SQLException {
		boolean result = dao.isUserLocked(uid);
		if (result) {// 계정 잠김
			throw new SQLException("계정이 잠겨있습니다.");
		} // result

		return result;
	}// getUserLocked

	/**
	 * 유저 마지막 로그인 날짜/IP 갱신
	 */
	public static boolean updateUserLastLogin(UserDTO user) throws SQLException {
		boolean result = dao.updateUserLastLogin(user);
		if (!result) {
			throw new SQLException("유저 마지막 로그인 날짜/IP 갱신실패");
		} // if

		return result;
	}// updateUserLastLogin

	/**
	 * 유저 활동 포인트 설정
	 */
	public static boolean setUserPoints(int uid, int numPoint) throws SQLException {
		boolean result = dao.setUserPoints(uid, numPoint);
		if (!result) {
			throw new SQLException("유저 활동 포인트 설정 실패");
		} // if

		return result;
	}// setUserPoints

	/**
	 * 유저 활동 포인트 확인
	 */
	public static int getUserPoints(UserDTO user) throws SQLException {
		int point = dao.getUserPoints(user);
		if (point < 0) {
			throw new SQLException("포인트 오류");
		}
		return point;
	}

	/**
	 * 유저 등급 아이디 확인
	 */
	public static int getUserRoleId(UserDTO user) throws SQLException {
		int roleId = dao.getUserRoleId(user);
		if (roleId < 0) {
			throw new SQLException("포인트 오류");
		}
		return roleId;
	}

	/**
	 * 유저 등급 아이디 설정
	 */
	public static boolean setUserRoleId(UserDTO user, int roleId) throws SQLException {
		boolean result = dao.setUserRoleId(user, roleId);
		if (!result) {
			throw new SQLException("유저 등급 설정 오류");
		}
		return result;
	}

	/**
	 * 유저 성인 나이 여부 설정
	 */
	public static boolean setUserAgeAdult(int uid, boolean isAdult) throws SQLException {
		boolean result = dao.setUserAgeAdult(uid, isAdult);
		if (!result) {
			throw new SQLException("성인나이 설정 오류");
		}
		return result;
	}

	/**
	 * 유저 성인 등급 열람 여부 설정
	 */
	public static boolean setUserViewAdult(int uid, boolean visible) throws SQLException {
		boolean result = dao.setUserViewAdult(uid, visible);
		if (!result) {
			throw new SQLException("성인등급 설정 오류");
		}
		return result;
	}

	/**
	 * 유저 성인 등급 열람 여부 확인
	 */
	public static boolean getUserViewAdult(UserDTO user) throws SQLException {
		boolean result = dao.getUserViewAdult(user);
		if (!result) {
			throw new SQLException("성인등급 설정 오류");
		}
		return result;
	}

	/**
	 * 유저 쪽지 전체 목록 불러오기
	 */
	public static List<Letter> getUserLetterList(int uid) throws SQLException {
		 List<Letter> list = dao.getUserLetterList(uid);
		 if(list.size()==0) {
			 throw new SQLException("쪽지 목록이 없습니다");
		 }
		 return list;
	}

	/**
	 * 유저 알람 확인
	 */
	public static int getUserNotification(int uid) throws SQLException {
		int numAlarms = dao.getUserNotification(uid);
		if (numAlarms < 0) {
			throw new SQLException("알람 값 오류");
		}
		return numAlarms;
	}

	/**
	 * 유저 가입 당시 아이피 확인
	 */
	public static String getUserFirstIP(int uid) throws SQLException {
		String ip = dao.getUserFirstIP(uid);
		if (ip == "") {
			throw new SQLException("아이피 오류");
		}
		return ip;
	}

	/**
	 * 유저 마지막 로그인 아이피 확인
	 */
	public static String getUserLastIP(int uid) throws SQLException {
		String lastIp = dao.getUserLastIP(uid);
		if (lastIp == "") {
			throw new SQLException("마지막 로그인 아이피 오류");
		}
		return lastIp;

	}

	/**
	 * 유저 가입 당시 날짜 확인
	 */
	public static String getUserFirstDate(int uid) throws SQLException {
		String creDate = dao.getUserFirstDate(uid);
		if (creDate == "") {
			throw new SQLException("가입날짜 오류");
		}
		return creDate;
	}

	/**
	 * 유저 마지막 로그인 날짜 확인
	 */
	public static String getUserLastDate(int uid) throws SQLException {
		String lastDate = dao.getUserLastDate(uid);
		if (lastDate == "") {
			throw new SQLException("마지막 로그인날자 오류");
		}
		return lastDate;
	}

	/**
	 * 계정 잠금
	 */
	public static boolean setUserLock(int uid, boolean lock) throws SQLException {
		boolean result = dao.setUserLock(uid, lock);
		if (!result) {
			throw new SQLException("계정 잠금이 실패하였습니다.");
		}
		return result;
	}

	

	/**
	 * 유저 닉네임 수정
	 * */
	public static boolean updateUserNickname(int uid, String nickname) throws SQLException {
		boolean result = dao.updateUserNickname(uid, nickname);
		if(!result) {
			throw new SQLException("닉네임 수정오류");
		}
		return result;
	}
	
	

}
