package pl.edu.uj.kognitywistyka.user.mb;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.user.model.Businessman;
import pl.edu.uj.kognitywistyka.user.model.Scientist;

public class Registration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7905519852872735487L;
	
	private String role;
	private String firstName;
	private String lastName;
	private String company;
	private String description;
	private String position;
	private String state;
	private String companyCategory;
	private String password;
	private String passConfirm;
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassConfirm(String passConfirm) {
		this.passConfirm = passConfirm;
	}

	public String getPassConfirm() {
		return passConfirm;
	}
	
	public String getCompanyCategory()
	{
		return companyCategory;
	}
	
	public void setCompanyCategory(String companyCategory)
	{
		this.companyCategory = companyCategory;
	}
	
	public void register()
	{
		if(role == "Businessman")
		{
			Businessman registered = new Businessman();
			registered.setFirstName(firstName);
			registered.setLastName(lastName);
			registered.setState(state);
			registered.setCompany(company);
			registered.setCompanyCategory(companyCategory);
			
			if(password == passConfirm)
			{
				registered.setPass(password);
			}
		}
		if(role == "Scientist")
		{
			Scientist registered = new Scientist();
			registered.setFirstName(firstName);
			registered.setLastName(lastName);
			registered.setState(state);
			registered.setUniversity(company);
			registered.setTitle(position);
			
			if(password == passConfirm)
			{
				registered.setPass(password);
			}
			
		}
		resetView();
	}
	
	private void resetView() {
		setDescription("");
		setFirstName("");
		setLastName("");
		setState("");
		setCompany("");
		setCompanyCategory("");
		
	}

}
