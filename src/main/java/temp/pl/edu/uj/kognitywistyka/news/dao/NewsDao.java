package temp.pl.edu.uj.kognitywistyka.news.dao;

import java.util.List;

import temp.pl.edu.uj.kognitywistyka.news.model.News;

public interface NewsDao {
	public void addNews(News news);
	public List<News> findAllNews();
}
