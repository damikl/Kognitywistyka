package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.aboutproject.dao.LinkDao;

public class LinkBoImpl implements Serializable, LinkBo {

	LinkDao linkDao;
	
	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}
}
