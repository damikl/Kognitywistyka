package pl.edu.uj.kognitywistyka.contact.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.contact.model.ContactRecipient;

public interface ContactRecipientDao {
	List<ContactRecipient> findAllContactRecipients();
}
