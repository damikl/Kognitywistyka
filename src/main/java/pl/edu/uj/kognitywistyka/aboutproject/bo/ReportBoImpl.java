package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.aboutproject.dao.ReportDao;

public class ReportBoImpl implements ReportBo, Serializable {

	ReportDao reportDao;
	
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
}
