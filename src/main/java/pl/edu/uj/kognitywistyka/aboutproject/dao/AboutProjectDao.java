package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.model.AboutProject;

public interface AboutProjectDao {

	AboutProject findLatestAboutProject();
}
