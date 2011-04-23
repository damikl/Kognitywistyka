package pl.edu.uj.kognitywistyka.contact.bo;

import javax.mail.MessagingException;

import pl.edu.uj.kognitywistyka.contact.dao.ContactRecipientDao;
import pl.edu.uj.kognitywistyka.util.Mailer;

public class ContactBoImpl implements ContactBo {
	
	private ContactRecipientDao contactRecipientDao;
	
	public void setContactRecipientDao(ContactRecipientDao contactRecipientDao) {
		this.contactRecipientDao = contactRecipientDao;
	}
	
	public void sendMessage(String from, String subject, String content) {
		//TODO: Odkomentować i usunąć to co jest aktualnie kiedy Ładan zrobi DAO
		
//		List<String> recipientsList = contactRecipientDao.findAllRecipients();
//		String[] recipients = (String[]) recipientsList.toArray();
//		
//		Mailer mailer = new Mailer(subject, content, from, recipients);
//		try {
//			mailer.send();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		
		try {
			Mailer.sendTestMail("froger.mcs@gmail.com", true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
