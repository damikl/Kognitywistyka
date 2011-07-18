package pl.edu.uj.kognitywistyka.user.dao;

import pl.edu.uj.kognitywistyka.user.model.User;

public interface UserDao {
	boolean checkUserExistanceByUserName(String userName);
	User createUser(User newUser);
	User getUser(String userName, String password);
	User getUserById(long userId);
}
