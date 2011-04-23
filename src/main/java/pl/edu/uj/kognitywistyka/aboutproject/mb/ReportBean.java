package pl.edu.uj.kognitywistyka.aboutproject.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.aboutproject.bo.ReportBo;
import pl.edu.uj.kognitywistyka.aboutproject.model.Report;

@ManagedBean
@RequestScoped
public class ReportBean implements Serializable {

	private static final long serialVersionUID = -8497001582603879607L;

	@ManagedProperty(name = "reportBo", value = "#{reportBo}")
	ReportBo reportBo;

	public void setReportBo(ReportBo reportBo) {
		this.reportBo = reportBo;
	}
	
	public List<Report> getAllReports() {
		return reportBo.findAllReports();
	}
}
