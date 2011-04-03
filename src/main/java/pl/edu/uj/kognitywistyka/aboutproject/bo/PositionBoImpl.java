package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.dao.PositionDao;
import pl.edu.uj.kognitywistyka.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.aboutproject.model.Position;

public class PositionBoImpl implements PositionBo, Serializable {
	private static final long serialVersionUID = 3556150937950571559L;
	PositionDao positionDao;

	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	public List<Position> findAllPosition() {
		return positionDao.findAllPositions();
	}

	public List<PositionList<Employee>> getEmployeesByPosition() 
	{
		List<PositionList<Employee>> genList = new ArrayList<PositionList<Employee>>();
		
		for (Position positionIter : positionDao.findAllPositions()) {
			PositionList<Employee> tmp = new PositionList<Employee>();
			tmp.setPosition(positionIter);
			for (Employee employeeIter : positionIter.getEmployees())
				tmp.add(employeeIter);

			genList.add(tmp);
		}
		return genList;
	}
}
