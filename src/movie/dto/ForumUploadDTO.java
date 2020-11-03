package movie.dto;

public class ForumUploadDTO {
	private int id;
	private int threadId;
	private int fileId;
	
	public ForumUploadDTO() {}
	public ForumUploadDTO(int id, int threadId, int fileId) {
		super();
		this.id = id;
		this.threadId = threadId;
		this.fileId = fileId;
	}//ForumUploadDTO 기본생성자
	
	
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
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
}//ForumUploadDTO
