package br.com.ehnois.springforum.dao;

import java.util.List;

import br.com.ehnois.springforum.entidades.Subject;
import br.com.ehnois.springforum.entidades.Topic;
import br.com.ehnois.springforum.entidades.User;

public interface DAOTopic extends DAOBase<Topic> {

	public List<Topic> getTopicosPorAutor(User usuario);

	public List<Topic> getTopicosPorAssunto(Subject assunto, int offset, int max);
}
