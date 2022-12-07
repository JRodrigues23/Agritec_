package br.edu.ifpe.agritec.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.agritec.dao.AgricultoresDao;
import br.edu.ifpe.agritec.model.Agricultores;
import br.edu.ifpe.agritec.model.Produto;



@Controller
@requestMapping
public class AgricultoresController {
	
	@GetMapping("administrativo/agricultores")
	public ModelAndView agricultores() {
		
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
		

		ModelAndView mv = new ModelAndView("administrativo/Agricultor/agricultores"); 
		mv.addObject("agricultores",agricultores);
		return mv;
		}
	

	
	
	//chama o DropDownList do produto que o agricultor porduz
	@GetMapping("administrativo/Agricultor/novoagricultor")
	public ModelAndView novoCliente() {
		ModelAndView mv = new  ModelAndView("administrativo/Agricultor/novoagricultor");
		mv.addObject("Produto", Produto.values());
		return mv;
	}
	

	


	//INSERINDO NO BANCO DE DADOS
	@Autowired
	AgricultoresDao agricultoresDao;
	

		@PostMapping("administrativo/agricultores")
		public ModelAndView createAgricultores(@Validated Agricultores agricultores, BindingResult bindingResults) {
			
			if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("administrativo/Agricultor/novoagricultor");
			mv.addObject("Produto",Produto.values());
			return mv;
			}
			
			try {
				agricultoresDao.adcionarAgricultores(agricultores);	
			} catch(ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
			
			
		
			//redirect do botão submeter 
			return new ModelAndView ( "redirect:/administrativo/agricultores");
	}
		
		
		
		//PARTE DE EDITAR 
		@GetMapping("administrativo/agricultor/editarAgricultor/{idagri}")
		public ModelAndView editar(@PathVariable ("idagri")int idagri) {
			
			Agricultores agricultores =null;
			try {
				agricultores =	agricultoresDao.colsultarAgricultoresId(idagri);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ModelAndView mv = new ModelAndView("administrativo/agricultor/editarAgricultor"); 
			mv.addObject("agricultores",agricultores);
			mv.addObject("Produto", Produto.values());
			return mv;		                                  	
		}
		
		
		
		@PostMapping("administrativo/agricultor/editarAgricultor/{idagri}")
		public ModelAndView update (@PathVariable int idagri,Agricultores agricultores , BindingResult bindingResults) {
			if(bindingResults.hasErrors()) {
				ModelAndView mv = new ModelAndView ("administrativo/agricultor/editarAgricultor");
				mv.addObject("Produto",Produto.values());
				return mv;
				
				}else {
					//int idagri1 = (int) idagri.intValue();
					try {
							agricultores.setIdagri(idagri);
							agricultoresDao.atualizarAgricultores(agricultores);		
					}catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					return new ModelAndView("redirect:/administrativo/agricultores");
				}	
		}
		
		//FIM DA PARTE DE EDITAR
		
		
		
		
		// PARTE DE DELETAR 
		
		@PostMapping ("/administrativo/agricultor/{idagri}/delete")
		public ModelAndView deleteAgricultor(@PathVariable int idagri) {
			//int idagri = (int) idagri.intValue():
				try {
					agricultoresDao.deletarAgricultores(idagri);
				} catch (ClassNotFoundException | SQLException e ) {
					e.printStackTrace();
				}
				return new ModelAndView("redirect:/administrativo/agricultores");
		}
		
		// FIM DA PARTE DE DELETAR 
		
	

}
