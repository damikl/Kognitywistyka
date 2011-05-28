package pl.edu.uj.kognitywistyka.user.bo;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.uj.kognitywistyka.user.dao.UserDao;
import pl.edu.uj.kognitywistyka.user.model.User;

@Transactional
public class UserBoImpl implements UserBo, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4991081556050600539L;
	private UserDao userDao;
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User userAuthentication(String userName, String password) {
		User u = userDao.getUser(userName, password);
		if(u != null)
			return u;
		else
			return null;
	}
	
	public boolean checkUserExistanceByUserName(String userName){
		return userDao.checkUserExistanceByUserName(userName);
	}
	
	public User createUser(User user){
		return userDao.createUser(user);
	}
}
