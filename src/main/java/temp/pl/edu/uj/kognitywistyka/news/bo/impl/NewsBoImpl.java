package temp.pl.edu.uj.kognitywistyka.news.bo.impl;

import java.util.List;

import temp.pl.edu.uj.kognitywistyka.news.bo.NewsBo;
import temp.pl.edu.uj.kognitywistyka.news.dao.NewsDao;
import temp.pl.edu.uj.kognitywistyka.news.model.News;

public class NewsBoImpl implements NewsBo {
	 
	NewsDao newsDao;
 
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
 
	public void addNews(News news){
 
		newsDao.addNews(news);
 
	}
 
	public List<News> findAllNews(){
 
		return newsDao.findAllNews();
	}
}
