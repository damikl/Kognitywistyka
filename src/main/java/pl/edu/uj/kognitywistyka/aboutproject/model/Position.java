package pl.edu.uj.kognitywistyka.aboutproject.model;

import java.util.ArrayList;
import java.util.List;

public class Position {
	private long positionId;
	private String name;
	private List<Employee> employees = new ArrayList<Employee>();

	public long getPositionId() {
		return positionId;
	}

	public void setPositionId(long postionId) {
		this.positionId = postionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

}