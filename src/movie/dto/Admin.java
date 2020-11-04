package movie.dto;

public class Admin {
	
	private int uid;
	private int userUid;
	
	//constructor
	public Admin() {}
	public Admin(int uid, int userUid) {
		super();
		this.uid = uid;
		this.userUid = userUid;
	}
	
	//set&get
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUserUid() {
		return userUid;
	}
	public void setUserUid(int userUid) {
		this.userUid = userUid;
	}
	
	
	

}
