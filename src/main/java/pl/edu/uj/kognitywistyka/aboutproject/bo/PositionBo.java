package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.aboutproject.model.Position;

public interface PositionBo {
	List<Position> findAllPosition();

	List<PositionList<Employee>> getEmployeesByPosition();

}
