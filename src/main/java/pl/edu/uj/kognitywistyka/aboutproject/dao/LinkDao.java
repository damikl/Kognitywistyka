package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.model.Link;

public interface LinkDao {

	List<Link> findAllLinks();
}
