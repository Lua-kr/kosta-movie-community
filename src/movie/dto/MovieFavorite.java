package movie.dto;

public class MovieFavorite {
	private int uid;
	private int userId;
	private int movieId;
	private String addDate;
	private int watch;
	
	//constructor
	public MovieFavorite(int uid, int userId, int movieId, String addDate, int watch) {
		super();
		this.uid = uid;
		this.userId = userId;
		this.movieId = movieId;
		this.addDate = addDate;
		this.watch = watch;
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
	public int getWatch() {
		return watch;
	}
	public void setWatch(int watch) {
		this.watch = watch;
	}
	
	
	
	
}
