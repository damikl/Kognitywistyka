package pl.edu.uj.kognitywistyka.gallery.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.gallery.dao.GalleryDao;
import pl.edu.uj.kognitywistyka.gallery.model.Gallery;

public class GalleryBoImpl implements Serializable, GalleryBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GalleryDao galleryDao;

	public void setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}

	public Gallery getGallery(long galleryID) {
		return galleryDao.getGallery(galleryID);
		
	}

	public List<Gallery> findAllGalleries() {
		return galleryDao.findAllGalleries();
	}

}
