package br.edu.fateczl.SpringAGIS.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.SpringAGIS.model.Dispensa;
import br.edu.fateczl.SpringAGIS.persistence.DispensaDao;
import br.edu.fateczl.SpringAGIS.persistence.GenericDao;

@Controller
public class SecretariaDispensaController {
	
	@Autowired
	GenericDao gDao;
	
	@Autowired
	DispensaDao dispDao;
	
	@RequestMapping(name="secretariadispensa", value="/secretariadispensa", method = RequestMethod.GET)
	public ModelAndView dispensaGet(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String erro = "";
		List<Dispensa> dispensas = new ArrayList<>();

		
		try {
			dispensas = listarDispensas();
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("dispensas", dispensas);
		}
		return new ModelAndView("secretariadispensa");
	}
	

	@RequestMapping(name="secretariadispensa", value="/secretariadispensa", method = RequestMethod.POST)
	public ModelAndView dispensaPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		
		return new ModelAndView("secretariadispensa");
	}
	
	private List<Dispensa> listarDispensas() throws ClassNotFoundException, SQLException {
		return dispDao.listar();
	}
}
