package pl.edu.uj.kognitywistyka.user.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.user.bo.ScientistBo;
import pl.edu.uj.kognitywistyka.user.model.User;


@ManagedBean
@RequestScoped
public class FullScientistNameBean {
	
	@ManagedProperty(name = "scientistBo", value = "#{scientistBo}")
	private ScientistBo scientistBo;
	
	private List<User> usersList;
	
	public void setScientistBo(ScientistBo scientistBo) {
		this.scientistBo = scientistBo;
	}
	
	public List<User> getUsersList() {
		if(this.usersList == null)
			this.usersList = this.scientistBo.findLastRegisteredScientist();
		for(User user : usersList)
		{
			System.out.println(user.getFirstName() + " " + user.getLastName());		
		}
		return this.usersList;
	}

}
