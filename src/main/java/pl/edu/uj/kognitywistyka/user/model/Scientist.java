package pl.edu.uj.kognitywistyka.user.model;

import java.io.Serializable;

public class Scientist extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7006674462671394997L;
	
	private String university;
//	private String description;
	private String title;
//	private String companyCategory;

/*	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCompanyCategory()
	{
		return companyCategory;
	}
	
	void setCompanyCategory(String companyCategory)
	{
		this.companyCategory = companyCategory;
	}
*/
	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUniversity() {
		return university;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
}
