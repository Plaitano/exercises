package br.com.ehnois.springforum.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.ehnois.springforum.dao.DAOTopic;
import br.com.ehnois.springforum.dao.DAOUser;
import br.com.ehnois.springforum.entidades.Topic;
import br.com.ehnois.springforum.entidades.User;

@Component
@Controller("user")
@SessionAttributes("user")
public class UsuarioController {

  @Autowired
  private DAOTopic daoTopic;
  
  @Autowired
  private DAOUser daoUser;

  public DAOTopic getDaoTopico() {
	return daoTopic;
  }

  public void setDaoTopic(DAOTopic daoTopic) {
	this.daoTopic = daoTopic;
  }

  public DAOUser getDaoUser() {
	return daoUser;
  }

  public void setDaoUser(DAOUser daoUser) {
	this.daoUser = daoUser;
  }

  @RequestMapping("/usuario/autenticado")
  public ModelAndView infoAutenticado(@ModelAttribute("user") User user) {
    ModelAndView mav = new ModelAndView("usuario.show", "user", user);
//    mav.getModel().put("usuario", usuario);
    
    return mav;
  }
  
  @RequestMapping("/usuario/avatar/{login}")
  @ResponseBody
  public byte[] avatar(@PathVariable("login") String login) throws IOException {
    File arquivo = new File("springForum/avatares/" + login + ".png");
    
    if (! arquivo.exists()) {
        arquivo = new File("springForum/avatares/avatar.png");
    }
    
    byte[] resultado = new byte[(int)arquivo.length()];
    FileInputStream input = new FileInputStream(arquivo);
    input.read(resultado);
    input.close();
    
    return resultado;    
  }
  
  @RequestMapping("/usuario/posts/{login}")
  public String topicoUsuario(@PathVariable("login") String login, Map<String, Object> model) {
	  model.put("topics", getDaoTopico().getTopicosPorAutor(getDaoUser().get(login)));	
	  return "usuario/posts";
  }
  
  @RequestMapping("/usuario/postsJSON/{login}")
  @ResponseBody
  public List<Topic> topicosUsuarioJson(@PathVariable("login") String login) {
	  User usuario = getDaoUser().get(login);
	  return getDaoTopico().getTopicosPorAutor(usuario);
  }
}
