package pl.edu.uj.kognitywistyka.aboutproject.bo;

import java.util.ArrayList;

import pl.edu.uj.kognitywistyka.aboutproject.model.Position;

public class PositionList<E> extends ArrayList<E> {
	private static final long serialVersionUID = -6445507894553811581L;
	private Position position;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
