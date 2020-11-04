package movie.dto;

public class Ouath {
	private int uid;
	private int userUid;
	private String accessToken;
	private String provider;
	
	//constructor
	public Ouath() {}
	public Ouath(int uid, int userUid, String accessToken, String provider) {
		super();
		this.uid = uid;
		this.userUid = userUid;
		this.accessToken = accessToken;
		this.provider = provider;
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
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	

}
