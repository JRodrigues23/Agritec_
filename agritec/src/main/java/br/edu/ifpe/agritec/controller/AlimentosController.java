package br.edu.ifpe.agritec.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping ("administrativo/Alimentos/novoalimentos")
	public ModelAndView novoalimentos() {
		ModelAndView mv = new  ModelAndView("administrativo/Alimentos/novoalimentos");
		//mv.addObject();
		return mv;	
	}
	
	
	//INSERINDO NO BANCO DE DADOS
	@Autowired
	AlimentosDao alimentosdao;
	
	@PostMapping("administrativo/alimentos")
	public ModelAndView createAlimentos(@Validated  Alimentos alimentos,BindingResult bindingResults) {
		
		if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("administrativo/Alimentos/novoalimentos");
			//mv.addObject("Produto",Produto.values());
			return mv;
			}
		
		try {
			alimentosdao.adicionarAlimentos(alimentos);	
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView ( "redirect:/administrativo/alimentos");

			
	}
	//UPDATE
	@PostMapping("administrativo/alimentos/editarAlimentos/{idAlimentos}")
	public ModelAndView update (@PathVariable int idAlimentos, Alimentos alimentos, BindingResult bindingResults) {
		if(bindingResults.hasErrors()){
		ModelAndView mv = new ModelAndView ("administrativo/alimentos/editarAlimentos");
		mv.addObject("Produto",Produto.values());
		return mv;
		
		}else {
			try {
				alimentos.setIdAlimentos(idAlimentos);
				alimentosdao.atualizarAlimentos(alimentos);
			}catch  (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return new ModelAndView("redirect/administrativo/alimentos");
		}
		
	}
	
	// PARTE DE DELETAR 
	
			@PostMapping ("/administrativo/alimentos/{idAlimentos}/delete")
			public ModelAndView deleteAlimentos(@PathVariable int idAlimentos) {
				//int idagri = (int) idagri.intValue():
					try {
						alimentosdao.deletarAlimentos(idAlimentos);
					} catch (ClassNotFoundException | SQLException e ) {
						e.printStackTrace();
					}
					return new ModelAndView("redirect:/administrativo/alimentos");
			}
			
			// FIM DA PARTE DE DELETAR 
			
	
	
	
	
	
	
}
