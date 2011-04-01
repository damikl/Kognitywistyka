package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.aboutproject.model.AboutProject;
import pl.edu.uj.kognitywistyka.aboutproject.dao.AboutProjectDao;

public class AboutProjectBoImpl implements AboutProjectBo, Serializable {

	private static final long serialVersionUID = 7538869973656457774L;
	
	AboutProjectDao aboutProjectDao;
	
	public void setAboutProjectDao(AboutProjectDao aboutProjectDao) {
		this.aboutProjectDao = aboutProjectDao;
	}

	public AboutProject findLatestAboutDescription() {
		return aboutProjectDao.findLatestAboutDescription();
	}

}