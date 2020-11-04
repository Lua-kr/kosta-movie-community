package movie.dto;

public class Letter {
	private int uid;
	private int sender_uid;
	private int receiver_uid;
	private String text;
	private String timedate;
	private boolean checked;
	
	public Letter(int uid, int sender_uid, int receiver_uid, String text, String timedate, boolean checked) {
		super();
		this.uid = uid;
		this.sender_uid = sender_uid;
		this.receiver_uid = receiver_uid;
		this.text = text;
		this.timedate = timedate;
		this.checked = checked;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSender_uid() {
		return sender_uid;
	}

	public void setSender_uid(int sender_uid) {
		this.sender_uid = sender_uid;
	}

	public int getReceiver_uid() {
		return receiver_uid;
	}

	public void setReceiver_uid(int receiver_uid) {
		this.receiver_uid = receiver_uid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTimedate() {
		return timedate;
	}

	public void setTimedate(String timedate) {
		this.timedate = timedate;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
