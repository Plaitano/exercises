package br.com.ehnois.springforum.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.ehnois.springforum.dao.DAOBase;

public abstract class DaoBaseImpl<T> implements DAOBase<T>{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	public abstract T get(String id);

	
	public void add(T obj) {
		getSession().saveOrUpdate(obj);
	}

	
	public void delete(T obj) {
		getSession().delete(obj);
	}
}
