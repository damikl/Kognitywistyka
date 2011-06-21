package pl.edu.uj.kognitywistyka.publication.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.publication.bo.PublicationBo;
import pl.edu.uj.kognitywistyka.publication.model.Publication;

@ManagedBean
@RequestScoped
public class PublicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "publicationBo", value = "#{publicationBo}")
	private PublicationBo publicationBo;

	public void setPublicationBo(PublicationBo publicationBo) {
		this.publicationBo = publicationBo;
	}

	public List<Publication> getAllPublication() {
		return publicationBo.findAllPublication();
	}

	public Publication getPublication(long id) {
		return publicationBo.getPublication(id);
	}
}
