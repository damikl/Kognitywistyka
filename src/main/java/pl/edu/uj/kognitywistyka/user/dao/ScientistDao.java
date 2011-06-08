package pl.edu.uj.kognitywistyka.user.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.User;

public interface ScientistDao {

	List<User> findAllScientist();

	User getScientist(Long id);
	List<User> findLastRegistered();
	List<User> findScientistFor(Long trade);

}
