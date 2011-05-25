package pl.edu.uj.kognitywistyka.user.bo;

import pl.edu.uj.kognitywistyka.user.model.User;

public interface UserBo {
    User userAuthentication(String user, String password);
	boolean checkUserExistanceByUserName(String userName);
	User createUser(User user);
}