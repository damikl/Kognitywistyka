package pl.edu.uj.kognitywistyka.user.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.Businessman;
import pl.edu.uj.kognitywistyka.user.model.Scientist;

public interface RegistrationDao {
	void add(Scientist sciencist);
	void add(Businessman businessman);
	void removeScientist(long scientistId);
	void removeBusinessman(long businessmanId);
	List<Scientist> findAllScientists();
	List<Businessman> findAllBusinessmans();
}
