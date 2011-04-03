package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.aboutproject.dao.EmployeeDao;

public class EmployeeBoImpl implements Serializable, EmployeeBo {
	private static final long serialVersionUID = 2934493575753599230L;
	EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


}
