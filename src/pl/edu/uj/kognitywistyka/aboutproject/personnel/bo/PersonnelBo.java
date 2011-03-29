package pl.edu.uj.kognitywistyka.aboutproject.personnel.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.personnel.model.Personnel;

public interface PersonnelBo {
	void addPersonnel(Personnel personel);

	List<Personnel> getPersonnel();

}
