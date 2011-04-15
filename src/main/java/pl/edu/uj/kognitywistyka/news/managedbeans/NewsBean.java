package pl.edu.uj.kognitywistyka.news.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.news.bo.NewsBo;
import pl.edu.uj.kognitywistyka.news.model.News;

@ManagedBean
@RequestScoped
public class NewsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "newsBo", value = "#{newsBo")
	NewsBo newsBo;

	public void setNewsBo(NewsBo newsBo) {
		this.newsBo = newsBo;
	}

	public List<News> getAllNews() {
		return newsBo.findAllNews();
	}

}
