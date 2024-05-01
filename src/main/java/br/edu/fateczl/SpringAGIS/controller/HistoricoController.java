package br.edu.fateczl.SpringAGIS.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HistoricoController {
	
	@RequestMapping(name = "historico", value="/historico", method = RequestMethod.GET)
	public ModelAndView historicoGet (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		return new ModelAndView("historico");
	}
	
	@RequestMapping(name = "historico", value="/historico", method = RequestMethod.POST)
	public ModelAndView historicoPost (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		return new ModelAndView("historico");
	}
	
}
