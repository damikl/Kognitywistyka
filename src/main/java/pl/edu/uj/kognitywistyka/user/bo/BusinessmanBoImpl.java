package pl.edu.uj.kognitywistyka.user.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.user.dao.BusinessmanDao;
import pl.edu.uj.kognitywistyka.user.model.User;

public class BusinessmanBoImpl implements BusinessmanBo, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714775377426294693L;
	private BusinessmanDao businessmanDao;
	
	public void setBusinessmanDao(BusinessmanDao businessmanDao)
	{
		this.businessmanDao = businessmanDao;
	}

	@Override
	public List<User> findAllBusinessman() {
		return this.businessmanDao.findAllBusinessman();
	}

	@Override
	public User getBusinessman(long id) {
		return this.businessmanDao.getBusinessman(id);
	}

	@Override
	public List<User> findLastRegistered() {
		return this.businessmanDao.findLastRegistered();
	}

	@Override
	public List<User> findBusinessmanFor(Long trade) {
		return this.businessmanDao.findBusinessmanFor(trade);
	}

}
