package pl.edu.uj.kognitywistyka.contact.bo;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import pl.edu.uj.kognitywistyka.contact.dao.ContactRecipientDao;
import pl.edu.uj.kognitywistyka.contact.model.ContactRecipient;
import pl.edu.uj.kognitywistyka.util.Mailer;

public class ContactBoImpl implements ContactBo {
	
	private ContactRecipientDao contactRecipientDao;
	
	public void setContactRecipientDao(ContactRecipientDao contactRecipientDao) {
		this.contactRecipientDao = contactRecipientDao;
	}
	
	public void sendMessage(String from, String subject, String content) {		
		List<String> recipientList = getRecipientList();
		String[] recipients = new String[recipientList.size()];
		recipients = recipientList.toArray(recipients);
		
		Mailer mailer = new Mailer(subject, content, from, recipients);
		try {
			mailer.send();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private List<String> getRecipientList() {
		List<ContactRecipient> contactRecipientsList = contactRecipientDao.findAllContactRecipients();
		List<String> recipientList = new ArrayList<String>();
		for (ContactRecipient contactRecipient : contactRecipientsList) {
			//Format: "FirstName LastName <email@address.com>"
			recipientList.add(contactRecipient.getFirstName() + " " +
							  contactRecipient.getLastName() + " <" +
							  contactRecipient.getEmail() + ">");
		}
		
		return recipientList;
	}

}
