package movie.dto;

public class ForumVote {
	private int uid;
	private int userId;
	private int countedId;
	private String forumtype;
	private int forumVote;
	private String date;
	
	//constructor
	public ForumVote() {}
	public ForumVote(int uid, int userId, int countedId, String forumtype, int forumVote, String date) {
		super();
		this.uid = uid;
		this.userId = userId;
		this.countedId = countedId;
		this.forumtype = forumtype;
		this.forumVote = forumVote;
		this.date = date;
	}

	
	//set&get
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCountedId() {
		return countedId;
	}

	public void setCountedId(int countedId) {
		this.countedId = countedId;
	}

	public String getForumtype() {
		return forumtype;
	}

	public void setForumtype(String forumtype) {
		this.forumtype = forumtype;
	}

	public int getForumVote() {
		return forumVote;
	}

	public void setForumVote(int forumVote) {
		this.forumVote = forumVote;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
