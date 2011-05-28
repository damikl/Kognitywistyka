package pl.edu.uj.kognitywistyka.user.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.user.model.User;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ScientistDaoImpl extends HibernateDaoSupport implements ScientistDao{
	
	@SuppressWarnings("unchecked")
	public List<User> findAllScientist() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(10);
		return ht.find("from User u where u.scientist='1' order by lastName desc");
	}

	@SuppressWarnings("unchecked")
	public User getScientist(Long id) {
		String query= "from User u where u.userId='"+id+"'";
		List<User> users = getHibernateTemplate().find(query); 
		return users.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> findScientistFor(Long tradeValue) {
		Long[] trades = new Long[1];
		trades[0] = tradeValue;
		String queryString= "from User u join u.trades t where t.tradeId in (:trades) group by u";
		
		Query query = this.getSession().createQuery(queryString);
		query.setParameterList("trades", trades);
		return query.list();
	}

}
