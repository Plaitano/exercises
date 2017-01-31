package br.com.ehnois.springforum.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Subject implements Serializable, Comparable<Subject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 926850753023979898L;

	protected long id;

	private String nome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int compareTo(Subject o) {
		return getNome().compareTo(o.getNome());
	}
}
