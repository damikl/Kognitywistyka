package pl.edu.uj.kognitywistyka.user.mb;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import pl.edu.uj.kognitywistyka.user.bo.UserBo;
import pl.edu.uj.kognitywistyka.user.model.User;

@ManagedBean
@RequestScoped
public class showUserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1526267089850470873L;
	
	@ManagedProperty(name = "userBo", value = "#{userBo}")
	private UserBo userBo;
	private User user;
	private long userId = 1;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String companyName;
	private String positionInCompany;
	private String companyDescription;
	private String region;

	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String userId = requestMap.get("id");
		Long longId = new Long(userId);
		//if(userId != null)
			preinitializeBean(longId.longValue());
	}
	
	private void preinitializeBean(long userId) {
		User user = userBo.getUser(userId);
		if(user != null) {
			this.userId = user.getUserId();
			this.userName = user.getUserName();
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.email = user.getEmail();
			this.companyName = user.getCompanyName();
			this.positionInCompany = user.getPositionInCompany();
			this.companyDescription = user.getCompanyDescription();
			this.region = user.getRegion();
		}
	}
	
	public User getUser(){
		return user;
	}
	
	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser(User createUser) {
		this.user = createUser;
		
	}
	
	public long getUserId(){
		return userId;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}
	
	public String getPositionInCompany() {
		return positionInCompany;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCompanyDescription() {
		return companyDescription;
	}
	
	public String getRegion() {
		return region;
	}
	
}