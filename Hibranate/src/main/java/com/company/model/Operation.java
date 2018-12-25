package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.utill.HibranateUtil;

public abstract class Operation<T, V extends Serializable> {

	public V insert(T t) {

		Session session = HibranateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		V object = null;

		try {
			tx = session.beginTransaction();
			object = (V) session.save(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return object;
	}

	public void edit(T t) {

		Session session = HibranateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(t);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(Class<T> cls, V v) {

		Session session = HibranateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			T t = (T) session.get(cls, v);
			session.delete(t);

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public T get(Class<T> type, V v) {

		T t = null;
		Session session = HibranateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			t = (T) session.get(type, v);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}


		return t;

	}

	public List<T> getAll(String queary){
		
		List<T> list = new ArrayList<T>();
		Session session = HibranateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery(queary).list();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
		
	}

}
