package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.aboutproject.model.AboutProject;

public class AboutProjectDaoImpl extends HibernateDaoSupport 
	implements AboutProjectDao {

	@SuppressWarnings("unchecked")
	private List<AboutProject> findAllAboutDescriptions() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(3);
		return getHibernateTemplate().find("from AboutProject order by Data desc");
	}

	public AboutProject findLatestAboutDescription() {
		return findAllAboutDescriptions().get(0);
	}

}
