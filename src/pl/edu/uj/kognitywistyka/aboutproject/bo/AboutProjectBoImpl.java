package pl.edu.uj.kognitywistyka.aboutproject.bo;

import pl.edu.uj.kognitywistyka.aboutproject.dao.AboutProjectDao;

public class AboutProjectBoImpl implements AboutProjectBo {
	AboutProjectDao apfrontdao;

	public void setAPFrontDao(AboutProjectDao apfrontdao) {
		this.apfrontdao = apfrontdao;
	}

	@Override
	public void setDescription(String desc) {
		apfrontdao.setDescription(desc);

	}

	@Override
	public String getDescription() {
		return apfrontdao.getDescription();
	}

}
