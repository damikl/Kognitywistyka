package temp.pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.util.List;

import temp.pl.edu.uj.kognitywistyka.aboutproject.model.Personnel;

public interface PersonnelBo {
	void addKadra(Personnel personel);

	List<Personnel> getPersonnel();

}
