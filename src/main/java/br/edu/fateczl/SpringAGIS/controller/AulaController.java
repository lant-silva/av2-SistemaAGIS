package br.edu.fateczl.SpringAGIS.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.SpringAGIS.persistence.GenericDao;

@Controller
public class AulaController {
	
	@Autowired
	GenericDao gDao;
	
	@RequestMapping(name = "aula", value="/aula", method = RequestMethod.GET)
	public ModelAndView aulaGet (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		
		return new ModelAndView("aula");
	}
	
	@RequestMapping(name = "aula", value="/aula", method = RequestMethod.POST)
	public ModelAndView aulaPost (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
	
			return new ModelAndView("aula");
	}
}
