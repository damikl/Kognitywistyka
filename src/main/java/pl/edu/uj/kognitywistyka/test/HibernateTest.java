package pl.edu.uj.kognitywistyka.test;

//import java.util.Iterator;
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import pl.edu.uj.kognitywistyka.aboutproject.model.Personnel;
//import pl.edu.uj.kognitywistyka.aboutproject.model.Position;
//import pl.edu.uj.kognitywistyka.util.SessionFactoryUtil;

public class HibernateTest
{
//	 //-- KLASA DO TESTÓW - chcesz pogrzebać, odkomentuj 
//	final static Logger logger = LoggerFactory.getLogger(HibernateTest.class);
//
//	public static void main(String args[]) throws Exception
//	{    	
//		Personnel foo1 = new Personnel();
//		foo1.setName("test3");
//		foo1.setSurname("test3");
//		foo1.setTitle("test3");
//		foo1.setDescription("test3");
//		
//		//Stanowiska st = new Stanowiska();
//		//st.setId(3);
//		//st.setNazwa("ładna");
//		//foo1.setStanowisko(st);
//		foo1.setPhoto("ładne");
//		createPersonnel(foo1,4);
//		// our instances have a primary key now:
//		logger.debug("{}", foo1);
//		listPersonnel();
//		//deletePersonnel(foo1);
//		//listPersonnel();
//		//foo1.setImie("test2");
//		//updatePersonnel(foo1);
//
//	}
//
//
//	private static void listPersonnel() {
//		Transaction tx = null;
//		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
//		try {
//			tx = session.beginTransaction();
//			List kadry = session.createQuery("select h from Personnel as h")
//			.list();
//			for (Iterator iter = kadry.iterator(); iter.hasNext();) {
//				Personnel element = (Personnel) iter.next();
//				logger.debug("{}", element);
//			}
//			
//			List kadraList = session.createQuery("from Personnel").list();
//	        for (int i = 0; i < kadraList.size(); i++)
//	        {
//	            Personnel kad = (Personnel) kadraList.get(i);
//	            System.out.println("Row " + (i + 1) + "> " + kad.getName() + "  " + kad.getSurname()
//	                    + " (" + kad.getPersonnelId() + ")");
//	        }
//			
//			
//			
//			
//			
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null && tx.isActive()) {
//				try {
//					// Second try catch as the rollback could fail as well
//					tx.rollback();
//				} catch (HibernateException e1) {
//					logger.debug("Error rolling back transaction");
//				}
//				// throw again the first exception
//				throw e;
//			}
//
//
//		}
//	}
//
//	private static void deletePersonnel(Personnel kadra) {
//		Transaction tx = null;
//		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
//		try {
//			tx = session.beginTransaction();
//			session.delete(kadra);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null && tx.isActive()) {
//				try {
//					// Second try catch as the rollback could fail as well
//					tx.rollback();
//				} catch (HibernateException e1) {
//					logger.debug("Error rolling back transaction");
//				}
//				// throw again the first exception
//				throw e;
//			}
//		}
//	}
//
//	private static void createPersonnel(Personnel kadra, int st) {
//		Transaction tx = null;
//		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
//		try {
//			tx = session.beginTransaction();
//			Position stanowisko = (Position) session.get(Position.class, new Integer(st));
//			kadra.setPosition(stanowisko);
//			session.save(kadra);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null && tx.isActive()) {
//				try {
//					// Second try catch as the rollback could fail as well
//					tx.rollback();
//				} catch (HibernateException e1) {
//					logger.debug("Error rolling back transaction");
//				}
//				// throw again the first exception
//				throw e;
//			}
//		}
//	}
//
//	private static void updatePersonnel(Personnel kadra) {
//		Transaction tx = null;
//		Session session = SessionFactoryUtil.getInstance().getCurrentSession();
//		try {
//			tx = session.beginTransaction();
//			session.update(kadra);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null && tx.isActive()) {
//				try {
//					// Second try catch as the rollback could fail as well
//					tx.rollback();
//				} catch (HibernateException e1) {
//					logger.debug("Error rolling back transaction");
//				}
//				// throw again the first exception
//				throw e;
//			}
//		}
//	}



}