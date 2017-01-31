package br.com.ehnois.springforum.dao.implementations;

import java.util.List;
import org.springframework.stereotype.Repository;

import br.com.ehnois.springforum.dao.DAOSubject;
import br.com.ehnois.springforum.entidades.Subject;

@Repository
public class SubjectDaoImpl extends DaoBaseImpl<Subject> implements DAOSubject {

	@SuppressWarnings("unchecked")
	public List<Subject> list() {
		return getSession().createQuery("from subject").list();
	}

	@Override
	public Subject get(String id) {
		return (Subject) getSession().get(Subject.class, id);
	}

}
