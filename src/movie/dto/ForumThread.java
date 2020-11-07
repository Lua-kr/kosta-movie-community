package movie.dto;

public class ForumThread {
	private int ftId;
	private int countRead;
	private int countPost;
	private int authorId;
	private int threadLocked;
	private int vote;
	private int postLocked;
	private String text;
	private String title;
	private String timeDate;
	
	public ForumThread() {}
	public ForumThread(int ftId, int countRead, int countPost, int authorId, int threadLocked, int vote, int postLocked,
			String text, String title, String timeDate) {
		super();
		this.ftId = ftId;
		this.countRead = countRead;
		this.countPost = countPost;
		this.authorId = authorId;
		this.threadLocked = threadLocked;
		this.vote = vote;
		this.postLocked = postLocked;
		this.text = text;
		this.title = title;
		this.timeDate = timeDate;
	}//BoardDTO 기본생성자
	
	public ForumThread(int ftId, int authorId, String text, String title) {
		this.ftId = ftId;
		this.authorId = authorId;
		this.text = text;
		this.title = title;
	}
	
	//getter setter
	public int getFtId() {
		return ftId;
	}
	public void setFtId(int ftId) {
		this.ftId = ftId;
	}
	public int getCountRead() {
		return countRead;
	}
	public void setCountRead(int countRead) {
		this.countRead = countRead;
	}
	public int getCountPost() {
		return countPost;
	}
	public void setCountPost(int countPost) {
		this.countPost = countPost;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getThreadLocked() {
		return threadLocked;
	}
	public void setThreadLocked(int threadLocked) {
		this.threadLocked = threadLocked;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public int getPostLocked() {
		return postLocked;
	}
	public void setPostLocked(int postLocked) {
		this.postLocked = postLocked;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}
	
	
}//BoardDTO