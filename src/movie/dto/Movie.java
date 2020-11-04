package movie.dto;

public class Movie {
	private int uid;
	private String lastUpdate;
	private String title;
	private String titleKor;
	private String productDate;
	private String openDate;
	private String country;
	private String genre;
	private String director;
	private int vote;
	private int voteCount;
	private int budget;
	private int adult;
	private int runTime;
	
	//constructor
	public Movie() {}
	public Movie(int uid, String lastUpdate, String title, String titleKor, String productDate, String openDate,
			String country, String genre, String director, int vote, int voteCount, int budget, int adult,
			int runTime) {
		super();
		this.uid = uid;
		this.lastUpdate = lastUpdate;
		this.title = title;
		this.titleKor = titleKor;
		this.productDate = productDate;
		this.openDate = openDate;
		this.country = country;
		this.genre = genre;
		this.director = director;
		this.vote = vote;
		this.voteCount = voteCount;
		this.budget = budget;
		this.adult = adult;
		this.runTime = runTime;
	}

	//set&get
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleKor() {
		return titleKor;
	}

	public void setTitleKor(String titleKor) {
		this.titleKor = titleKor;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	
	

}
