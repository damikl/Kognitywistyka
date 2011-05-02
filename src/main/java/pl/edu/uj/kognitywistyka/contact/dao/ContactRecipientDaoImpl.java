package pl.edu.uj.kognitywistyka.contact.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.contact.model.ContactRecipient;

public class ContactRecipientDaoImpl extends HibernateDaoSupport  
implements ContactRecipientDao {
	
	@SuppressWarnings("unchecked")
	public List<ContactRecipient> findAllContactRecipients() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(10);
		return getHibernateTemplate().find("from ContactRecipient order by lastName asc");
	}
}
