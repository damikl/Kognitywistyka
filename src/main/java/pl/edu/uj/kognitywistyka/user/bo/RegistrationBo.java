package pl.edu.uj.kognitywistyka.user.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.Businessman;
import pl.edu.uj.kognitywistyka.user.model.Scientist;
import pl.edu.uj.kognitywistyka.user.model.User;

public interface RegistrationBo {
	void register(Scientist scientist);
	void register(Businessman businessman);
	void register(User registered);
	void removeScientist(long scientistId);
	void removeBusinessman(long businessmanId);
	void remove(Scientist scientist);
	void remove(Businessman businessman);
	List<Scientist> findAllScientists();
	List<Businessman> findAllBusinessmans();
	
}
