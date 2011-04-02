package pl.edu.uj.kognitywistyka.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.aboutproject.model.Position;

public interface PositionDao {

	List<Position> findAllPositions();
}
