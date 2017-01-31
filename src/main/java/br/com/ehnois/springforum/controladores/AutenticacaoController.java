package br.com.ehnois.springforum.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ehnois.springforum.dao.DAOUser;
import br.com.ehnois.springforum.entidades.User;

@Controller
public class AutenticacaoController {

	@Autowired
	private DAOUser daoUser;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession session) {


		User user = daoUser.get(login);
		
		if(user == null)
			return "loginFailure";
		
		
		session.setAttribute("user", user);
		return "redirect:/usuario/autenticado";
	}
}
