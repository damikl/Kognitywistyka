package pl.edu.uj.kognitywistyka.user.mb;

import java.io.Serializable;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import pl.edu.uj.kognitywistyka.user.bo.UserBo;
import pl.edu.uj.kognitywistyka.user.model.User;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1526267089850470873L;
	
	@ManagedProperty(name = "userBo", value = "#{userBo}")
	private UserBo userBo;
	private User user;
	private String userName;
	private String password;

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

	public String login(){
		user = userBo.userAuthentication(userName, password);
		if(user != null){
			return "index";

		}else
		{
			FacesMessage message = new FacesMessage("Invalid user/password");
			FacesContext context = FacesContext.getCurrentInstance();
			UIComponent mybutton = findComponent(context.getViewRoot(), "mybutton");
			context.addMessage(mybutton.getClientId(context), message);
			return "";

		}
	}

	private UIComponent findComponent(UIComponent parent, String id) {
		if(id.equals(parent.getId())) {
			return parent;
		}
		Iterator<UIComponent> kids = parent.getFacetsAndChildren();
		while(kids.hasNext()) {
			UIComponent kid = kids.next();
			UIComponent found = findComponent(kid, id);
			if(found != null) {
				return found;
			}
		}
		return null;
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();

		final HttpServletRequest request = (HttpServletRequest)ec.getRequest();
		request.getSession( false ).invalidate();
		user = null;
		return "logout";
	}

	public boolean isLoggedIn(){
		return user != null;
	}

	public void setUser(User createUser) {
		this.user = createUser;
		
	}

	

}