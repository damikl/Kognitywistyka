package pl.edu.uj.kognitywistyka.user.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.User;

public interface BusinessmanDao {
	List<User> findAllBusinessman();

	User getBusinessman(Long id);
	List<User> findLastRegistered();
	List<User> findBusinessmanFor(Long trade);
}
