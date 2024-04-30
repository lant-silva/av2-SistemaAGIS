package br.edu.fateczl.SpringAGIS.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MatriculaController {
	
	
	@RequestMapping(name = "matricula", value="/matricula", method = RequestMethod.GET)
	public ModelAndView matriculaGet (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		LocalDate dataAtual = LocalDate.now();
		boolean intervaloSemestre = validarDataSemestral(dataAtual);
		
		model.addAttribute("intervalo", intervaloSemestre);
		return new ModelAndView("matricula");
	}
	

	@RequestMapping(name = "matricula", value="/matricula", method = RequestMethod.POST)
	public ModelAndView matriculaPost (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		
		return new ModelAndView("matricula");
	}
	
	private boolean validarDataSemestral(LocalDate dataAtual) {
		// TODO Auto-generated method stub
		return false;
	}
}
