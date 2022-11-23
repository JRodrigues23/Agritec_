package br.edu.ifpe.agritec.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.agritec.dao.AgricultoresDao;
import br.edu.ifpe.agritec.model.Agricultores;
import br.edu.ifpe.agritec.model.ProdutoProduzido;

;

@Controller
public class AgricultoresController {
	
	@GetMapping("/agricultores")
	public ModelAndView agricultores() {
		//Agricultores agricultores = new Agricultores(1,"12345678900","Darlles", "darlles@gmail.com","uva");
		//Cliente Cliente2 = new Cliente(2,"Daniele","Rua aha", "Palmares","pe");
		//Cliente Cliente3 = new Cliente(3,"Rocha","Rua ifpe", "agua preta","pe");
				
		//List<Cliente> clientes = Arrays.asList(Cliente1,Cliente2,Cliente3);
		
		AgricultoresDao agricultoresdao = new AgricultoresDao();
		List<Agricultores> agricultores=null;
		try {
			agricultores = agricultoresdao.colsultarTodosAgricultores();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		ModelAndView mv = new ModelAndView("Agricultor/agricultores"); 
		mv.addObject("agricultores",agricultores);
		return mv;
		}
	
	
	//@GetMapping("cliente/new")
	//public String novoCliente() {
		//return "cliente/new";
	//}
	
	@GetMapping
	("Agricultor/novoagricultor")
	public ModelAndView novoAgricultor() {
		ModelAndView mv = new ModelAndView("Agricultor/novoagricultor");
		mv.addObject("ProdutoProduzido",ProdutoProduzido.values());
		return mv;
		
	}
	
	//redirect 
	
	//@PostMapping("/clientes")
	//public String createCliente() {
		//return "redirect:/clientes";
		
	//}
	
	@Autowired
	AgricultoresDao agricultoresDao;

		@PostMapping("/agricultores")
		public ModelAndView createAgricultores(@Validated Agricultores agricultores, BindingResult bindingResults) {
			
			if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Agricultor/novoagricultor");
			mv.addObject("ProdutoProduzido",ProdutoProduzido.values());
			return mv;
			}
			
			try {
				agricultoresDao.adcionarAgricultores(agricultores);	
			} catch(ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
			
			return new ModelAndView ( "redirect:/agricultores");
					
	
	}

}
