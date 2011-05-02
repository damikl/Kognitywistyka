package pl.edu.uj.kognitywistyka.publication.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.publication.model.Publication;

public interface PublicationDao {

	List<Publication> findAllPublication();
	Publication getPublication(long id);
	
}
