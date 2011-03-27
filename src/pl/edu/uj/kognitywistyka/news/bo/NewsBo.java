package pl.edu.uj.kognitywistyka.news.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.news.model.News;

public interface NewsBo {
	 
	void addNews(News news);
 
	List<News> findAllNews();
 
}
