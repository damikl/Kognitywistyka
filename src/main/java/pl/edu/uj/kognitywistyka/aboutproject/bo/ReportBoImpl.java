package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.dao.ReportDao;
import pl.edu.uj.kognitywistyka.aboutproject.model.Report;

public class ReportBoImpl implements ReportBo, Serializable {

	private static final long serialVersionUID = -1489793869534421850L;
	ReportDao reportDao;
	
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public List<Report> findAllReports() {
		return reportDao.findAllReports();
	}
}
