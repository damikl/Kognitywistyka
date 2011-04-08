package pl.edu.uj.kognitywistyka.news.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.news.model.News;

public interface NewsDao {
	
	List<News> findAllNews();
	
	News getNews(News news);
	
}
