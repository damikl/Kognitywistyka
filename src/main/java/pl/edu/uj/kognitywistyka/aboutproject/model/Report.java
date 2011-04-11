package pl.edu.uj.kognitywistyka.aboutproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report{
	private long reportId;
	private String title;
	private Date date;
	private String content;
	
	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("dd-mm-yyyy");
	
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long raportId) {
		this.reportId = raportId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}