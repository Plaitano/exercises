package br.com.ehnois.springforum.entidades;

import javax.persistence.*;

@Entity 
@Table(name="user")
public class User {

	@Column(name = "name")
	private String name;

	
	@Column(name = "email")
	private String email;

	@Id
	@Column(name = "login")
    private String login;
	
    @Column(name = "password")
	private String password;

	public String getName() {
		return name;
	}
	
	public void setNome(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
