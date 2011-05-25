package pl.edu.uj.kognitywistyka.user.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.user.dao.RegistrationDao;
import pl.edu.uj.kognitywistyka.user.model.Businessman;
import pl.edu.uj.kognitywistyka.user.model.Scientist;
import pl.edu.uj.kognitywistyka.user.model.User;

public class RegistrationBoImpl implements RegistrationBo, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2086590711970836005L;

	RegistrationDao registrationDao;
	
	public void setRegistrationDao(RegistrationDao registrationDao)
	{
		this.registrationDao = registrationDao;
	}
	
	@Override
	public void register(Scientist scientist) {
		this.registrationDao.add(scientist);
		
	}

	@Override
	public void register(Businessman businessman) {
		this.registrationDao.add(businessman);
		
	}

	@Override
	public void removeScientist(long scientistId) {
		this.registrationDao.removeScientist(scientistId);
	}

	@Override
	public void removeBusinessman(long businessmanId) {
		this.registrationDao.removeBusinessman(businessmanId);
	}

	@Override
	public void remove(Scientist scientist) {
		this.removeScientist(scientist.getUserId());
	}

	@Override
	public void remove(Businessman businessman) {
		this.removeBusinessman(businessman.getUserId());	
	}

	@Override
	public List<Scientist> findAllScientists() {
		return this.registrationDao.findAllScientists();
	}

	@Override
	public List<Businessman> findAllBusinessmans() {
		return this.registrationDao.findAllBusinessmans();
	}

	@Override
	public void register(User registered) {
		if(registered instanceof Businessman)
		{
			this.register((Businessman)registered);
		}
		if(registered instanceof Scientist)
		{
			this.register(registered);
		}
	}

}
