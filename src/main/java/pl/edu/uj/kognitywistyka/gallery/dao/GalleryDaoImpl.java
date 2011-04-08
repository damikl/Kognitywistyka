package pl.edu.uj.kognitywistyka.gallery.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.gallery.model.Gallery;

public class GalleryDaoImpl extends HibernateDaoSupport implements GalleryDao{

	
	public void getGallery(Gallery gallery) {
		getHibernateTemplate().get(Gallery.class, gallery.getGalleryId());
	}

	@SuppressWarnings("unchecked")
	public List<Gallery> findAllGalleries() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(8);
		return ht.find("from Gallery order by date desc");
	}

}
