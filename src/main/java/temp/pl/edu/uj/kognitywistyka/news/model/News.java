package temp.pl.edu.uj.kognitywistyka.news.model;

import java.util.Date;

public class News {
	private String title;
	private Date addDate;
	private String content;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public Date getAddDate() {
		return addDate;
	}

	public String getContent() {
		return content;
	}

}
