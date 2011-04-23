package temp.pl.edu.uj.kognitywistyka.visitor.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import temp.pl.edu.uj.kognitywistyka.visitor.UnauthorizedAccessAttempt;
import temp.pl.edu.uj.kognitywistyka.visitor.UserInfo;

@ManagedBean(name = "visitor")
@SessionScoped
public class VisitorBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean loggedIn;
	private UserInfo user;

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserInfo getUser() throws UnauthorizedAccessAttempt {
		if (isLoggedIn())
			return user;
		else
			throw new UnauthorizedAccessAttempt();
	}

	public VisitorBean() {

	}
}
