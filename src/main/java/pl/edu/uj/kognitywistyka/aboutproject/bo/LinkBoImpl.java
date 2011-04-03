package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.dao.LinkDao;
import pl.edu.uj.kognitywistyka.aboutproject.model.Link;

public class LinkBoImpl implements Serializable, LinkBo {

	private static final long serialVersionUID = -7573122674865425495L;
	LinkDao linkDao;

	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	public List<Link> findAllLinks() {
		return linkDao.findAllLinks();
	}
}
