package pl.edu.uj.kognitywistyka.request.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Request{
	private long requestId;
	private String title;
	private Date date;
	private String company;
	private String person;
	private String tags;
	private String content;
	
	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("dd-mm-yyyy");
	
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	
	public String shortDate() {
		return shortDateFormatter.format(date);
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}