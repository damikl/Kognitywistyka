package pl.edu.uj.kognitywistyka.news.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.news.dao.NewsDao;
import pl.edu.uj.kognitywistyka.news.model.News;

public class NewsBoImpl implements Serializable, NewsBo {

	private static final long serialVersionUID = 1L;
	private NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public List<News> findAllNews() {
		return newsDao.findAllNews();
	}

	public News getNews(long newsId) {
		return newsDao.getNews(newsId);
	}

}
