package br.com.ehnois.springforum.controladores;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@RequestMapping(value="/restshit")
	public String performRestRequest() {
		
		return "Angelo, Rafael, James, Alex";
	}

	@RequestMapping(value="/calculateSells")
	public Float calculateSells() {
		
		return new Float(3 * 3.14);
	}
}
