package pl.edu.uj.kognitywistyka;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.aboutproject.front.bo.APFrontBo;

@ManagedBean
@RequestScoped
public class AboutProjectFrontBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	APFrontBo apfrontbo;

	public String description;

	public String getDescription() {
		return description;
	}
/*
	public void setDescription(String description) {
		this.description = description;
	}
*/
	public void setAPFrontBo(APFrontBo apfrontbo) {
		this.apfrontbo = apfrontbo;
	}
}
