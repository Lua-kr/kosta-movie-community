package movie.dto;

public class PointShop {
	private int id;
	private String name;
	private String type;
	private int point;
	private int stock;
	private int fileId;
	private int reqRoldId;
	private int locked;
	
	public PointShop() {}
	public PointShop(int id, String name, String type, int point, int stock, int fileId, int reqRoldId, int locked) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.point = point;
		this.stock = stock;
		this.fileId = fileId;
		this.reqRoldId = reqRoldId;
		this.locked = locked;
	}
	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getReqRoldId() {
		return reqRoldId;
	}
	public void setReqRoldId(int reqRoldId) {
		this.reqRoldId = reqRoldId;
	}
	public int getLocked() {
		return locked;
	}
	public void setLocked(int locked) {
		this.locked = locked;
	}
	
	
	
	
}//PointShop