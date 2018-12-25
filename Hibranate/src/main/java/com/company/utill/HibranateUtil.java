package com.company.utill;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibranateUtil {

	private static SessionFactory sessionFactory = bulidSessionFactory();

	private static SessionFactory bulidSessionFactory() {

		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {

			throw new ExceptionInInitializerError(e);
		}

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public static void shutdown() {
		sessionFactory.close();
	}



}
