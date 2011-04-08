package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.aboutproject.model.AboutProject;

public class AboutProjectDaoImpl extends HibernateDaoSupport 
implements AboutProjectDao {

	@SuppressWarnings("unchecked")
	private List<AboutProject> findAllAboutProjects() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(3);
		return ht.find("from AboutProject order by date desc");
	}

	public AboutProject findLatestAboutProject() {
		List<AboutProject> list = findAllAboutProjects(); 
		return list.isEmpty() ? null : list.get(0);
	}

}