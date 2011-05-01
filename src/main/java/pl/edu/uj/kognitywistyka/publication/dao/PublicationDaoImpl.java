package pl.edu.uj.kognitywistyka.publication.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.publication.model.Publication;

public class PublicationDaoImpl extends HibernateDaoSupport implements PublicationDao {

	@SuppressWarnings("unchecked")
	public List<Publication> findAllPublication() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(10);
		return ht.find("from Publication order by date desc");
	}

	public Publication getPublication(long id) {
		return (Publication) getHibernateTemplate().get(Publication.class, id);
	}

	
}
