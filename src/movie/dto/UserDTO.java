package movie.dto;

import javax.servlet.http.HttpSession;

public class UserDTO {
	private int uid; // 고유 유저 번호
	private int roleId; // 등급 번호
	private String name; // 닉네임
	private String email;// 메일
	private String creIp;// 가입 아이피
	private String creDate; // 가입일
	private boolean lock; // 계정 잠금 유무
	private String lastDate; // 마지막접속일
	private String lastIp; // 마지막 접속 아이피
	private int points; // 활동 포인트
	private boolean viewAdult; // 성인 등급 열람 여부
	private boolean ageAdult; // 나이 성인 여부
	private HttpSession session; // 사용자 세션

	// 로그인 시
	public UserDTO(int uid, int roleId, String name, String email, String creIp, String creDate, boolean lock,
			String lastDate, String lastIp, int points, boolean viewAdult, boolean ageAdult, HttpSession session) {
		this.uid = uid;
		this.roleId = roleId;
		this.name = name;
		this.email = email;
		this.creIp = creIp;
		this.creDate = creDate;
		this.lock = lock;
		this.lastDate = lastDate;
		this.lastIp = lastIp;
		this.points = points;
		this.viewAdult = viewAdult;
		this.ageAdult = ageAdult;
		this.session = session;
	}

	// 가입 시
	public UserDTO(int uid, String name, String email, String ip, String date, HttpSession session) {
		this.uid = uid;
		this.roleId = 0;
		this.name = name;
		this.email = email;
		this.creIp = ip;
		this.creDate = date;
		this.lock = false;
		this.lastDate = date;
		this.lastIp = ip;
		this.points = 0;
		this.viewAdult = false;
		this.ageAdult = false;
		this.session = session;
	}

	// set&get
	public int getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public String getIp() {
		return creIp;
	}

	public void setIp(String ip) {
		this.creIp = ip;
	}

	public String getCreDate() {
		return creDate;
	}

	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}

	public boolean getLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean isViewAdult() {
		return viewAdult;
	}

	public void setViewAdult(boolean viewAdult) {
		this.viewAdult = viewAdult;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isAgeAdult() {
		return ageAdult;
	}

	public void setAgeAdult(boolean ageAdult) {
		this.ageAdult = ageAdult;
	}

	public String getCreIp() {
		return creIp;
	}

	public HttpSession getSession() {
		return session;
	};

}// class
