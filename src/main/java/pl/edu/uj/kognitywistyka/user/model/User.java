package pl.edu.uj.kognitywistyka.user.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

public class User implements Serializable {

	private static final long serialVersionUID = 6916816325466379714L;

	private Long userId;
	private boolean active = true;
	private String activationKey =" sdd ";
	private boolean temporaryPassword = false;
	private String passwordHash;
	@Pattern(regexp="^[a-zA-Z\\d_]{4,12}$", message="Invalid screen name.")
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private String positionInCompany;
	private boolean scientist;
	private boolean businessman;
	private String city;
	private String region;
	private String companyDescription;
	private Set<Trade> trades = new HashSet<Trade>(0);
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long value) {
		this.userId = value;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String value) {
		this.userName = value;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean value) {
		this.active = value;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String value) {
		this.firstName = value;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String value) {
		this.lastName = value;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String value) {
		this.activationKey = value;
	}

	@Column(name = "password",length = 32)
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String value) {
		this.passwordHash = value;
	}

	public boolean isTemporaryPassword() {
		return temporaryPassword;
	}

	public void setTemporaryPassword(boolean value) {
		this.temporaryPassword = value;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPositionInCompany() {
		return positionInCompany;
	}

	public void setPositionInCompany(String positionInCompany) {
		this.positionInCompany = positionInCompany;
	}

	public boolean isScientist() {
		return scientist;
	}

	public void setScientist(boolean scientist) {
		this.scientist = scientist;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String toString() {
		String myFullName = null;
		if (firstName != null) {
			if (lastName != null) {

				myFullName = firstName+" "+lastName;

			}
		} else {
			if (lastName != null) {
				myFullName = lastName;
			} else {
				myFullName = userName;
			}
		}
		return myFullName;
	}

	public int hashCode() {
		return (userName != null) ? userName.hashCode() : super.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!getClass().equals(obj.getClass())) return false;
		User x = (User)obj;
		// see: Hibernate In Action, pg. 124-125
		return equals(userName, x.userName); // equals via business key
	}

	protected final boolean equals(final Object left, final Object right) {
		return (left != null) ? left.equals(right) : (right == null);
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setBusinessman(boolean businessman) {
		this.businessman = businessman;
	}

	public boolean getBusinessman() {
		return businessman;
	}
}
