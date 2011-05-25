package pl.edu.uj.kognitywistyka.user.model;

import java.io.Serializable;


public class Businessman extends User implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -552442872820743137L;
	
	private String company;
	private String description;
	private String position;
	private String[] companyCategory;
	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String[] getCompanyCategory()
	{
		return companyCategory;
	}
	
	public void setCompanyCategory(String[] companyCategory)
	{
		this.companyCategory = companyCategory;
	}

}
