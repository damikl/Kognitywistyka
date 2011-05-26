package pl.edu.uj.kognitywistyka.user.bo;

import pl.edu.uj.kognitywistyka.user.model.Businessman;
import pl.edu.uj.kognitywistyka.user.model.Scientist;

public interface RegistrationBo {
	boolean register(Scientist scientist);
	boolean register(Businessman scientist);

}
