package pl.edu.uj.kognitywistyka.user.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.User;

public interface ScientistBo {

	List<User> findAllScientist();

	User getScientist(long id);

	List<User> findScientistFor(Long trade);

}
