package br.edu.ifpe.agritec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.agritec.dao.AgricultoresDao;

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

	//acessa a tela de alimentos da tela inicial 
	@GetMapping("/administrativo/usuarios/alimen")
	public String acessarTabelaalimento() {
		return "administrativo/usuarios/alimen";
	}
	
	//acessa a tela de CONTATOS da tela inicial 
		@GetMapping("/administrativo/usuarios/contato")
		public String acessarcontato() {
			return "administrativo/usuarios/contato";
		}
		
		
	//acessa a tela de fornecedores da tela inicial
	@Autowired
	private AgricultoresDao agricultoresdao;
	
	@GetMapping ("/administrativo/usuarios/FornecedoresAgri")
	public String FornecedoresAgri() {
		//ModelAndView mv = ModelAndView ("/administrativo/usuarios/FornecedoresAgri");
		//mv.addObject("FornecedoresAgri", agricultoresdao.findAll());
		return "administrativo/usuarios/FornecedoresAgri";	
	}
	
	public ModelAndView ExibirFornecedores() {
		ModelAndView mv = new ModelAndView("/administrativo/usuarios/FornecedoresAgri");
		mv.addObject("agricultores", agricultoresdao.findAll());
		return mv;
	}

	

	
}
