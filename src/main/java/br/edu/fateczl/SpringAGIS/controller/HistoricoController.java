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

import br.edu.fateczl.SpringAGIS.model.Aluno;
import br.edu.fateczl.SpringAGIS.model.Disciplina;
import br.edu.fateczl.SpringAGIS.persistence.AlunoDao;
import br.edu.fateczl.SpringAGIS.persistence.DisciplinaDao;
import br.edu.fateczl.SpringAGIS.persistence.GenericDao;

@Controller
public class HistoricoController {
	
	@Autowired 
	GenericDao gDao;
	
	@Autowired 
	AlunoDao aDao;
	
	@Autowired
	DisciplinaDao dDao;
	
	@RequestMapping(name = "historico", value="/historico", method = RequestMethod.GET)
	public ModelAndView historicoGet (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		
		return new ModelAndView("historico");
	}
	
	@RequestMapping(name = "historico", value="/historico", method = RequestMethod.POST)
	public ModelAndView historicoPost (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		String ra = allRequestParam.get("ra");
		
		Aluno a = new Aluno();
		Disciplina d = new Disciplina();
		List<Disciplina> disciplinas = new ArrayList<>();
		String saida = "";
		String erro = "";
		
		try {
			if(cmd.contains("Consultar")) {
				a.setRa(ra);
				a = buscarAluno(a);
				disciplinas = listarDisciplinas
			}
		} catch (SQLException | ClassNotFoundException e) {
			
		} finally {
			
		}
		
		
		return new ModelAndView("historico");
	}
	
}
