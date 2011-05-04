package pl.edu.uj.kognitywistyka.publication.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.publication.model.Publication;

public interface PublicationBo {
	List<Publication> findAllPublication();
	Publication getPublication(long id);
}
