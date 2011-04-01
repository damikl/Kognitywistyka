package pl.edu.uj.kognitywistyka.aboutproject.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.aboutproject.bo.AboutProjectBo;
import pl.edu.uj.kognitywistyka.aboutproject.model.AboutProject;

@ManagedBean
@RequestScoped
public class AboutProjectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Dependency injection via Spring
	@ManagedProperty(name="aboutProjectBo", value="#{aboutProjectBo}")
	AboutProjectBo aboutProjectBo;

	public void setAboutProjectBo(AboutProjectBo aboutProjectBo) {
		this.aboutProjectBo = aboutProjectBo;
	}
	
	//Nie potrzebujemy pola description ponieważ wartość tą odczytujemy z obiektu BO
	//Poza tym nie używamy settera, ponieważ w przypadku strony wartość ta ma być jedynie odczytywana
//	private String description;

	public String getDescription() {
		if(aboutProjectBo != null)
			return aboutProjectBo.findLatestAboutDescription().getDescription();
		else
			return "";
	}

	public AboutProject getAboutDescription() {
		return aboutProjectBo.findLatestAboutDescription();
	}
}
