package pl.edu.uj.kognitywistyka.aboutproject.model;

public class Link{
	private long linkId;
	private String name;
	private String url;
	private String description;
	
	public long getLinkId() {
		return linkId;
	}
	public void setLinkId(long linkId) {
		this.linkId = linkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}