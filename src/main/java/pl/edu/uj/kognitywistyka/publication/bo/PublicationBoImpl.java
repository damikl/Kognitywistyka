package pl.edu.uj.kognitywistyka.publication.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.publication.dao.PublicationDao;
import pl.edu.uj.kognitywistyka.publication.model.Publication;

public class PublicationBoImpl implements PublicationBo, Serializable {
	
	private static final long serialVersionUID = 1L;

	private PublicationDao publicationDao;

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

	public List<Publication> findAllPublication() {
		return publicationDao.findAllPublication();
	}

	public Publication getPublication(long id) {
		return publicationDao.getPublication(id);
	}

}
