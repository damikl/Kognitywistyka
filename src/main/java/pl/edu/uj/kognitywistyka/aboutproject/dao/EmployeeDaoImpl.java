package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.aboutproject.model.Employee;


public class EmployeeDaoImpl extends HibernateDaoSupport 
	implements EmployeeDao{

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		return getHibernateTemplate().find("from Employee order by lastName asc");
	}
	
}