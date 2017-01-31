package br.com.ehnois.springforum.dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.ehnois.springforum.dao.DAOTopic;
import br.com.ehnois.springforum.entidades.Subject;
import br.com.ehnois.springforum.entidades.Topic;
import br.com.ehnois.springforum.entidades.User;

@Component("br.com.ehnois.springforum.dao.DAOTopico")
@Repository
public class TopicDaoImpl extends DaoBaseImpl<Topic> implements DAOTopic{

	private String[] titulos = {"Como eu configuro o Spring?", 
			"Problema com suporte a DAO", 
			"Como funciona AOP?", 
			"Duvida com Spring Security",
			"JDBCTemplate: como eu uso?", 
			"Configuracao XML: problema", 
			"Projeto de exemplo", 
			"Hibernate: como definir o SessionFactory?", 
			"DataSource: como obter via JNDI?", 
			"Como funciona a requisicao no MVC?", 
			"Aonde uso o Spring?"};

	public List<Topic> getTopicosPorAutor(User usuario) {
		List<Topic> resultado = new ArrayList<Topic>();
		if (usuario != null) {
			int num_registros = (int) (Math.random() * titulos.length);
			for (int i = 0; i < num_registros; i++) {
				Topic topico = new Topic();
				topico.setTitulo(titulos[i]);
				resultado.add(topico);
			}			
		}
		return resultado;
	}

	public List<Topic> getTopicosPorAssunto(Subject assunto, int offset, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Topic> list() {
		return getSessionFactory().getCurrentSession().createQuery("from Topic").list();
	}

	@Override
	public Topic get(String id) {
		return (Topic) getSession().get(Topic.class, id);
	}

}
