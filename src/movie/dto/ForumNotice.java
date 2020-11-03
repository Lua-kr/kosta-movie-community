package movie.dto;

public class ForumNotice {
	private int id;
	private int threadId;
	private int allForum;
	
	
	public ForumNotice() {}
	public ForumNotice(int id, int threadId, int allForum) {
		super();
		this.id = id;
		this.threadId = threadId;
		this.allForum = allForum;
	}//ForumNotice
	
	
	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public int getAllForum() {
		return allForum;
	}
	public void setAllForum(int allForum) {
		this.allForum = allForum;
	}
	
	
	
	
}//ForumNotice