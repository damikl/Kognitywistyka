package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.model.Employee;

public interface EmployeeDao {

	List<Employee> findAllEmployees();

}
