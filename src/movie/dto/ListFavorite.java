package movie.dto;

public class ListFavorite {
	private int uid;
	private int userId;
	private int movieId;
	private String addDate;
	
	//constructor
	public ListFavorite() {}
	public ListFavorite(int uid, int userId, int movieId, String addDate) {
		super();
		this.uid = uid;
		this.userId = userId;
		this.movieId = movieId;
		this.addDate = addDate;
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
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
	

}
