package movie.dto;

public class ForumPost {
	private int id;
	private String text;
	private int threadId;
	private int authorId;
	private int vote;
	private String timeDate;
	
	public ForumPost() {}
	public ForumPost(int id, String text, int threadId, int authorId, int vote, String timeDate) {
		super();
		this.id = id;
		this.text = text;
		this.threadId = threadId;
		this.authorId = authorId;
		this.vote = vote;
		this.timeDate = timeDate;
	}//ForumPost
	
	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public String getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}
	
	
}//ForumPost