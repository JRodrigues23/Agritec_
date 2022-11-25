package br.edu.ifpe.agritec.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.agritec.dao.AlimentosDao;
import br.edu.ifpe.agritec.model.Alimentos;
import br.edu.ifpe.agritec.model.Produto;

@Controller
public class AlimentosController {
	
	@GetMapping("administrativo/alimentos")
	public ModelAndView alimentos() {
		
		AlimentosDao alimentosdao = new AlimentosDao();
		List<Alimentos> alimentos=null;
		try {
			alimentos = alimentosdao.consultarTodosAlimentos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		ModelAndView mv = new ModelAndView("administrativo/Alimentos/alimentos");
		mv.addObject("alimentos",alimentos);
		return mv;
	}

	@GetMapping ("Alimentos/novoalimentos")
	public ModelAndView novoalimentos() {
		ModelAndView mv = new  ModelAndView("Alimentos/novoalimentos");
		//mv.addObject();
		return mv;	
	}
	
	@Autowired
	AlimentosDao alimentosdao;
	
	@PostMapping("/alimentos")
	public ModelAndView createAlimentos(@Validated  Alimentos alimentos,BindingResult bindingResults) {
		
		if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Alimentos/novoalimentos");
			//mv.addObject("Produto",Produto.values());
			return mv;
			}
		
		try {
			alimentosdao.adicionarAlimentos(alimentos);	
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView ( "redirect:/alimentos");

			
	}
	
	
	
}
