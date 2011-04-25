package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.aboutproject.model.Report;


public class ReportDaoImpl extends HibernateDaoSupport
	implements ReportDao{

	
	@SuppressWarnings("unchecked")
	public List<Report> findAllReports() {
		return getHibernateTemplate().find("from Report order by date desc");
	}
	
	public Report getReport(long id) {
		return (Report) getHibernateTemplate().get(Report.class, id);
	}


}