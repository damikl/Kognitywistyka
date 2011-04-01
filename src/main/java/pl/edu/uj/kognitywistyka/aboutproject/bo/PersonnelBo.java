package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.model.Personnel;

public interface PersonnelBo {
	void addKadra(Personnel personel);

	List<Personnel> getPersonnel();

}
