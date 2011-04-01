package pl.edu.uj.kognitywistyka.aboutproject.model;

import java.sql.Date;

public class AboutProject{
	private int aboutProjectId;
	private String description;
	private Date date;
	public int getAboutProjectId() {
		return aboutProjectId;
	}
	public void setAboutProjectId(int aboutProjectId) {
		this.aboutProjectId = aboutProjectId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}