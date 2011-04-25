package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.aboutproject.model.Link;


public class LinkDaoImpl extends HibernateDaoSupport
	implements LinkDao{

	
	@SuppressWarnings("unchecked")
	public List<Link> findAllLinks() {
		return getHibernateTemplate().find("from Link order by linkId asc");
	}
	

}