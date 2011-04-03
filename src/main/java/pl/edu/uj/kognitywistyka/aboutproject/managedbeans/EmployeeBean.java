package pl.edu.uj.kognitywistyka.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.aboutproject.bo.PositionBo;
import pl.edu.uj.kognitywistyka.aboutproject.bo.PositionList;
import pl.edu.uj.kognitywistyka.aboutproject.model.Employee;


@ManagedBean
@RequestScoped
public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 4241366958741596166L;

	
	@ManagedProperty(name="positionBo", value="#{positionBo}")
	PositionBo positionBo;
	
	public void setPositionBo(PositionBo positionBo) {
		this.positionBo = positionBo;
	}
	
	public List< PositionList<Employee> > getEmployeesByPosition() {
		return positionBo.getEmployeesByPosition();
	}


	

}
