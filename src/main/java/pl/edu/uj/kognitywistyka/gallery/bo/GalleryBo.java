package pl.edu.uj.kognitywistyka.gallery.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.gallery.model.Gallery;

public interface GalleryBo {
	Gallery getGallery(long galleryID);

	List<Gallery> findAllGalleries();

}
