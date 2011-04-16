package pl.edu.uj.kognitywistyka.gallery.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.gallery.bo.GalleryBo;
import pl.edu.uj.kognitywistyka.gallery.model.Gallery;

@ManagedBean
@RequestScoped
public class GalleryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "galleryBo", value = "#{galleryBo}")
	GalleryBo galleryBo;

	public void setGalleryBo(GalleryBo galleryBo) {
		this.galleryBo = galleryBo;
	}

	public List<Gallery> getAllGalleries() {
		return galleryBo.findAllGalleries();
	}

	public Gallery getGallery(long galleryID) {
		return galleryBo.getGallery(galleryID);
	}

	public Gallery getGallery(Gallery gallery) {
		return galleryBo.getGallery(gallery.getGalleryId());
	}

}
