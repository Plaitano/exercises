package br.com.ehnois.springforum.controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ehnois.springforum.entidades.User;

@Controller
public class HomeController {

	@RequestMapping(value="registro")
	public String registro(Map<String, Object> model) {
		if (model.get("user") == null) {
			model.put("user", new User());
		}
		return "registro";
	}

	@RequestMapping(value = "/executarRegistro", method = RequestMethod.POST)
	public String executarRegistro(@Valid User user, BindingResult bindingResult, HttpSession sessao,
			@RequestParam(value = "avatar", required = false) MultipartFile avatar) {

		if (bindingResult.hasErrors()) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("user", user);
			return registro(model);
		}

		// getDaoUsuario().persistir(usuario);

		if (! avatar.isEmpty()) {
			processarAvatar(user, avatar);
		}		
		sessao.setAttribute("user", user);
		return "usuario.show";
	}
	
	private void processarAvatar(User usuario, MultipartFile avatar) {
		File diretorio = new File("springForum/avatares");
		if (! diretorio.exists()) {
			diretorio.mkdirs();
		}
		try {
		  FileOutputStream arquivo = new FileOutputStream(diretorio.getAbsolutePath() + "/" + usuario.getLogin() + ".png");
			arquivo.write(avatar.getBytes());
			arquivo.close();
		} catch (IOException ex) {
			System.out.println("Failed to write avatar.");
		}
	}	
}
