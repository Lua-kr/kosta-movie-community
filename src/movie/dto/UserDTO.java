package movie.dto;

public class UserDTO {
	private int uid; // 고유유저번호
	private String name; // 닉네임
	private String email;// 메일
	private String ip;// 아이피
	private String creDate; // 가입일
	private String lock; // 아이피 밴 유무
	private String lastDate; // 마지막접속일
	private String lastIp; // 마지막 접속 아이피
	private int point; // 활동 포인트

	// constructor
	public UserDTO() {
	}
	
	//정보수정시 ??
	public UserDTO(String name, String email, String ip, String lastDate, int point) {
		super();
		this.name = name;
		this.email = email;
		this.ip = ip;
		this.lastDate = lastDate;
		this.point = point;
	}

	public UserDTO(int uid, String name, String email, String ip, String creDate, String lock, String lastDate,
			String lastIp, int point) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.ip = ip;
		this.creDate = creDate;
		this.lock = lock;
		this.lastDate = lastDate;
		this.lastIp = lastIp;
		this.point = point;
	}

	// set&get
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCreDate() {
		return creDate;
	}

	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	};

}// class
