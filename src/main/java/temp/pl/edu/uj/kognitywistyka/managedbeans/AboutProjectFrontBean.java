package temp.pl.edu.uj.kognitywistyka.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import temp.pl.edu.uj.kognitywistyka.aboutproject.bo.AboutProjectBo;

@ManagedBean
@RequestScoped
public class AboutProjectFrontBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AboutProjectBo apfrontbo;

	public String description;

	public String getDescription() {
		return description;
	}
/*
	public void setDescription(String description) {
		this.description = description;
	}
*/
	public void setAPFrontBo(AboutProjectBo apfrontbo) {
		this.apfrontbo = apfrontbo;
	}
}
