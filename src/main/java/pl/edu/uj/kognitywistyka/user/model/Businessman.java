package pl.edu.uj.kognitywistyka.user.model;

import java.io.Serializable;


public class Businessman implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -552442872820743137L;
	
	private long userId;
	private String firstName;
	private String lastName;
	private String company;
	private String description;
	private String position;
	private String region;
	private String[] companyCategory;
	private String pass;
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

}
