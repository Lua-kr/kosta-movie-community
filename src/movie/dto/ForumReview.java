package movie.dto;

public class ForumReview {
	private int id;
	private int threadId;
	private int movieId;
	private String rate;
	
	public ForumReview() {}
	public ForumReview(int id, int threadId, int movieId, String rate) {
		super();
		this.id = id;
		this.threadId = threadId;
		this.movieId = movieId;
		this.rate = rate;
	}//ForumReview
	
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
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
}//ForumReview