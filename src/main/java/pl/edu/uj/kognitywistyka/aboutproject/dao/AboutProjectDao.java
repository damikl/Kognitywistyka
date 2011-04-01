package pl.edu.uj.kognitywistyka.aboutproject.dao;

import pl.edu.uj.kognitywistyka.aboutproject.model.AboutProject;

public interface AboutProjectDao {
	AboutProject findLatestAboutDescription();
}
