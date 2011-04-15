package pl.edu.uj.kognitywistyka.news.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.news.model.News;

public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

	@SuppressWarnings("unchecked")
	public List<News> findAllNews() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(3);
		return ht.find("from News order by date desc");
	}

	public News getNews(long newsId) {
		return (News) getHibernateTemplate().get(News.class, newsId);
	}

}
