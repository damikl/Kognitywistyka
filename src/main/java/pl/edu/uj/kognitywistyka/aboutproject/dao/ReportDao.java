package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.model.Report;

public interface ReportDao {
	List<Report> findAllReports();
}
