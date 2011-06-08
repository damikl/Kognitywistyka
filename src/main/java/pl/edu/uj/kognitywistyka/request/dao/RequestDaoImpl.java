package pl.edu.uj.kognitywistyka.request.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.request.model.Request;


public class RequestDaoImpl extends HibernateDaoSupport
	implements RequestDao{

	public void addRequest(Request request) {
		getHibernateTemplate().save(request);
		
	}
	
	public void removeRequest(Request request) {
		getHibernateTemplate().delete(request);
		
	}
	
	@Override
	public void updateRequest(Request request) {
		getHibernateTemplate().update(request);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> findAllRequests() {
		return getHibernateTemplate().find("from Request order by date desc");
	}
	
	public Request getRequest(long id) {
		return (Request) getHibernateTemplate().get(Request.class, id);
	}


}