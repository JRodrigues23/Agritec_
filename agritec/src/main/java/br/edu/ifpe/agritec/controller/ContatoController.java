package br.edu.ifpe.agritec.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.agritec.dao.ContatoDao;
import br.edu.ifpe.agritec.model.Contato;


@Controller
@RequestMapping
public class ContatoController {
	
	//INSERINDO NO BANCO DE DADOS
		@Autowired
		ContatoDao contatodao;
		
		@PostMapping("/administrativo/contato")
		public ModelAndView createContato(@Validated  Contato contato,BindingResult bindingResults) {
			
			if(bindingResults.hasErrors()) {
				ModelAndView mv = new ModelAndView("/administrativo/usuarios/contato");
				//mv.addObject("Produto",Produto.values());
				return mv;
				}
			
			try {
				contatodao.adcionarContato(contato);	
			} catch(ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
			
			return new ModelAndView ( "redirect:/administrativo");

				
		}
	

}
