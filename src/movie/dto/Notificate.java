package movie.dto;

public class Notificate {
	private int uid;
	private int senderId;
	private int receiverId;
	private int countedId;
	private int nType;
	private String date;
	private int nRead;
	
	//constructor
	public Notificate() {}
	public Notificate(int uid, int senderId, int receiverId, int countedId, int nType, String date, int nRead) {
		super();
		this.uid = uid;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.countedId = countedId;
		this.nType = nType;
		this.date = date;
		this.nRead = nRead;
	}

	//set&get
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getCountedId() {
		return countedId;
	}

	public void setCountedId(int countedId) {
		this.countedId = countedId;
	}

	public int getnType() {
		return nType;
	}

	public void setnType(int nType) {
		this.nType = nType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getnRead() {
		return nRead;
	}

	public void setnRead(int nRead) {
		this.nRead = nRead;
	}
	
	

}
