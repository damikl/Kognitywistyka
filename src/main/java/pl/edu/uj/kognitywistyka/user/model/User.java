package pl.edu.uj.kognitywistyka.user.model;

public abstract class User {

	private long userId;
	private String firstName;
	private String lastName;
	private String city;
	private String region;
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
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion() {
		return region;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}
	
}
