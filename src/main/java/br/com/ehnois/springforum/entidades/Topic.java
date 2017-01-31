package br.com.ehnois.springforum.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3714392743066723650L;

	protected long id;
	
	private Subject assunto;
	
	private User autor;
	
	private Date dataCadastro = new Date();
	
	private String titulo;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Subject getAssunto() {
		return assunto;
	}
	
	public void setAssunto(Subject assunto) {
		this.assunto = assunto;
	}
	
	public User getAutor() {
		return autor;
	}
	
	public void setAutor(User autor) {
		this.autor = autor;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
