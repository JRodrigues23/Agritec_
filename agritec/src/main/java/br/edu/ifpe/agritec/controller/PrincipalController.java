package br.edu.ifpe.agritec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	
	//pagina inicial do Agritec
	@GetMapping("/administrativo")
	public String acessarHome() {
		return "administrativo/index";
	}
	
	
	//acessa o painel de controle 
	@GetMapping("/administrativo/usuarios")
	public String acessarPrincipal() {
		return "administrativo/usuarios/home";
	}

}
