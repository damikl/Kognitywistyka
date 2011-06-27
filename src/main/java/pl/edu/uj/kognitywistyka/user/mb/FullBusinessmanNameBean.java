package pl.edu.uj.kognitywistyka.user.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.user.bo.BusinessmanBo;
import pl.edu.uj.kognitywistyka.user.model.User;


@ManagedBean
@RequestScoped
public class FullBusinessmanNameBean {
	
	@ManagedProperty(name = "businessmanBo", value = "#{businessmanBo}")
	private BusinessmanBo businessmanBo;
	
	private List<User> usersList;
	
	public void setBusinessmanBo(BusinessmanBo businessmanBo) {
		this.businessmanBo = businessmanBo;
	}
	
	public List<User> getUsersList() {
		if(this.usersList == null)
			this.usersList = this.businessmanBo.findLastRegistered();
		for(User user : usersList)
		{
			System.out.println(user.getFirstName() + " " + user.getLastName());		
		}
		return this.usersList;
	}

}
