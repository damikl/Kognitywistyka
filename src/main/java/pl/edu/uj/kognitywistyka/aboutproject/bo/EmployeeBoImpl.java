package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.aboutproject.dao.EmployeeDao;

public class EmployeeBoImpl implements Serializable, EmployeeBo {
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}
