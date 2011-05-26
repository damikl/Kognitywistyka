package pl.edu.uj.kognitywistyka.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.user.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    public User createUser(User u) {
        String userName = u.getUserName();        
        getHibernateTemplate().save(u);
        return u;
    }

  
	@SuppressWarnings("unchecked")
	public User getUser(String userName, String password) {
		User u = null;
		String query= "from User u where u.userName='"+userName+"' and u.passwordHash ='"+password+"'";
		List<User> users =getHibernateTemplate().find(query); 
		if(users != null && !users.isEmpty()) u = users.get(0);
		return u;
	}

	@SuppressWarnings("unchecked")
	public boolean checkUserExistanceByUserName(String userName) {
		String query= "from User u where u.userName='"+userName+"'";
		List<User> users =getHibernateTemplate().find(query); 
		if(users != null && !users.isEmpty()) return true;
		else return false;
		
	}
	
	
	
}