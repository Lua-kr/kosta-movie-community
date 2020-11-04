package movie.dto;

public class File {
	private int uid;
	private int userId;
	private String fileName;
	private int fileSize;
	private String fileType;
	private String date;
	private int imgHeight;
	private int imgWidth;
	
	//constructor
	public File() {}
	public File(int uid, int userId, String fileName, int fileSize, String fileType, String date, int imgHeight,
			int imgWidth) {
		super();
		this.uid = uid;
		this.userId = userId;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.date = date;
		this.imgHeight = imgHeight;
		this.imgWidth = imgWidth;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
	public int getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

	

}
