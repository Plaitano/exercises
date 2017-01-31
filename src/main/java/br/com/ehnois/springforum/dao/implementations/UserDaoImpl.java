package br.com.ehnois.springforum.dao.implementations;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ehnois.springforum.dao.DAOUser;
import br.com.ehnois.springforum.entidades.User;

@Repository
@Transactional 
public class UserDaoImpl extends DaoBaseImpl<User> implements DAOUser {

	@SuppressWarnings("unchecked")
	public List<User> list() {
		return getSessionFactory().getCurrentSession().createQuery("from br.com.ehnois.springforum.entidades.User").list();
	}

	@Override
	public User get(String id) {
		return (User) getSession().get(User.class, id);
	}

}
