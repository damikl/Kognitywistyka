package pl.edu.uj.kognitywistyka.aboutproject.front.bo.impl;

import pl.edu.uj.kognitywistyka.aboutproject.front.bo.APFrontBo;
import pl.edu.uj.kognitywistyka.aboutproject.front.dao.APFrontDao;

public class APFrontBoImpl implements APFrontBo {
	APFrontDao apfrontdao;

	public void setAPFrontDao(APFrontDao apfrontdao) {
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
