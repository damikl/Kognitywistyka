package temp.pl.edu.uj.kognitywistyka.news;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import temp.pl.edu.uj.kognitywistyka.news.bo.NewsBo;
import temp.pl.edu.uj.kognitywistyka.news.model.News;

@ManagedBean(name = "news")
@RequestScoped
public class NewsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	NewsBo newsBo;

	public NewsBean() {

	}

	public List<News> getNewsList() {
		return newsBo.findAllNews();
	}

}
