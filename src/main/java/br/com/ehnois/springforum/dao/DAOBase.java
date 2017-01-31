package br.com.ehnois.springforum.dao;

import java.util.List;

public interface DAOBase<T> {
	
	public List<T> list();
	
	public void add(T objet);
	
	public void delete(T object);
	
	public T get(String id);
}
