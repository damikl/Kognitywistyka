package pl.edu.uj.kognitywistyka.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.aboutproject.bo.LinkBo;
import pl.edu.uj.kognitywistyka.aboutproject.model.Link;

@ManagedBean
@RequestScoped
public class LinkBean implements Serializable {

	private static final long serialVersionUID = -1750886013264679813L;

	@ManagedProperty(name = "linkBo", value = "#{linkBo}")
	LinkBo linkBo;
	
	public void setLinkBo(LinkBo linkBo) {
		this.linkBo = linkBo;
	}
	
	public List<Link> getAllLinks() {
		return linkBo.findAllLinks();
	}

}
