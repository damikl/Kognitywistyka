package pl.edu.uj.kognitywistyka.publication.mb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pl.edu.uj.kognitywistyka.publication.bo.PublicationBo;
import pl.edu.uj.kognitywistyka.publication.model.Publication;

@ManagedBean
@RequestScoped
public class PublicationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Publication> allPublication;

	@ManagedProperty(name = "publicationBo", value = "#{publicationBo}")
	private PublicationBo publicationBo;

	public void setPublicationBo(PublicationBo publicationBo) {
		this.publicationBo = publicationBo;
	}

	public List<Publication> getAllPublication() {
		if(allPublication == null)
			allPublication = publicationBo.findAllPublication();
		return allPublication;
	}

	public Publication getPublication(long id) {
		return publicationBo.getPublication(id);
	}
	
	public Publication getPublication() {
	    FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        
        int id;
        
        try {
            id = Integer.parseInt(paramMap.get("id"));
        } catch (NumberFormatException n) {
            return null;
        }
        
        if (id > 0 && id <= getAllPublication().size()) {
            return getPublication(id);
        } else {
            return null;
        }
	}
}
