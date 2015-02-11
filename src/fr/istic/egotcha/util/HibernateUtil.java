package fr.istic.egotcha.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Erreur de creation" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
