package pl.edu.uj.kognitywistyka.user.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.user.dao.ScientistDao;
import pl.edu.uj.kognitywistyka.user.model.User;

public class ScientistBoImpl implements ScientistBo, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6919760465868520642L;
	
	private ScientistDao scientistDao;
	
	public void setScientistDao(ScientistDao scientistDao)
	{
		this.scientistDao = scientistDao;
	}
	
	public List<User> findAllScientist() {
		return scientistDao.findAllScientist();
	}

	public User getScientist(long id) {
		return scientistDao.getScientist(id);
	}

	@Override
	public List<User> findScientistFor(Long trade) {
		return scientistDao.findScientistFor(trade);
	}

}
