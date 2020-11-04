package movie.dto;

public class UserRole {
	private int uid;
	private String userName;
	private int point;
	private int priority;
	
	//constructor
	public UserRole() {}
	public UserRole(int uid, String userName, int point, int priority) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.point = point;
		this.priority = priority;
	}

	//set&get
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	

}
