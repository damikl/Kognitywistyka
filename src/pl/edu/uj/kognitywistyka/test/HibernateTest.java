package pl.edu.uj.kognitywistyka.test;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.edu.uj.kognitywistyka.model.Kadra;
import pl.edu.uj.kognitywistyka.model.Stanowiska;
import pl.edu.uj.kognitywistyka.util.SessionFactoryUtil;

public class HibernateTest
{
	final static Logger logger = LoggerFactory.getLogger(HibernateTest.class);

	public static void main(String args[]) throws Exception
	{    	
		Kadra foo1 = new Kadra();
		foo1.setImie("test3");
		foo1.setNazwisko("test3");
		foo1.setTytul("test3");
		foo1.setOpis("test3");
		
		//Stanowiska st = new Stanowiska();
		//st.setId(3);
		//st.setNazwa("ładna");
		//foo1.setStanowisko(st);
		foo1.setZdjecie("ładne");
		createKadra(foo1,4);
		// our instances have a primary key now:
		logger.debug("{}", foo1);
		listKadra();
		//deleteKadra(foo1);
		//listKadra();
		//foo1.setImie("test2");
		//updateKadra(foo1);

	}


	private static void listKadra() {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			List kadry = session.createQuery("select h from Kadra as h")
			.list();
			for (Iterator iter = kadry.iterator(); iter.hasNext();) {
				Kadra element = (Kadra) iter.next();
				logger.debug("{}", element);
			}
			
			List kadraList = session.createQuery("from Kadra").list();
	        for (int i = 0; i < kadraList.size(); i++)
	        {
	            Kadra kad = (Kadra) kadraList.get(i);
	            System.out.println("Row " + (i + 1) + "> " + kad.getImie() + "  " + kad.getNazwisko()
	                    + " (" + kad.getId() + ")");
	        }
			
			
			
			
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					logger.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}


		}
	}

	private static void deleteKadra(Kadra kadra) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.delete(kadra);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					logger.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	private static void createKadra(Kadra kadra, int st) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			Stanowiska stanowisko = (Stanowiska) session.get(Stanowiska.class, new Integer(st));
			kadra.setStanowisko(stanowisko);
			session.save(kadra);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					logger.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}

	private static void updateKadra(Kadra kadra) {
		Transaction tx = null;
		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.update(kadra);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					logger.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}



}