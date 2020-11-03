package movie.dto;

public class ForumCategory {
	private int id;
	private int reqRead;
	private int reqWrite;
	private String guest;
	
	public ForumCategory() {}
	public ForumCategory(int id, int reqRead, int reqWrite, String guest) {
		super();
		this.id = id;
		this.reqRead = reqRead;
		this.reqWrite = reqWrite;
		this.guest = guest;
	}//ForumCategory
	
	
	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReqRead() {
		return reqRead;
	}
	public void setReqRead(int reqRead) {
		this.reqRead = reqRead;
	}
	public int getReqWrite() {
		return reqWrite;
	}
	public void setReqWrite(int reqWrite) {
		this.reqWrite = reqWrite;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	
	
}//ForumCategory