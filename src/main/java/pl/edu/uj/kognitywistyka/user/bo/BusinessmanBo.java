package pl.edu.uj.kognitywistyka.user.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.User;

public interface BusinessmanBo {
	
	List<User> findAllBusinessman();

	User getBusinessman(long id);
	
	List<User> findLastRegistered();
	
	List<User> findBusinessmanFor(Long trade);
	
}
