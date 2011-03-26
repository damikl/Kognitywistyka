package pl.edu.uj.kognitywistyka;

import java.text.SimpleDateFormat;

public class Announcement {
	private String title;
	private SimpleDateFormat date;
	private String content;

	public Announcement(String title, SimpleDateFormat date, String content) {
		super();
		this.title = title;
		this.date = date;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
