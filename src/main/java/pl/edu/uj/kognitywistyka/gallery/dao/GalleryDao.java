package pl.edu.uj.kognitywistyka.gallery.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.gallery.model.Gallery;

public interface GalleryDao {
	void getGallery(Gallery gallery);
	List<Gallery> findAllGalleries();
	
}
