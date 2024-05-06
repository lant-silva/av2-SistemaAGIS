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
import br.edu.fateczl.SpringAGIS.model.Professor;
import br.edu.fateczl.SpringAGIS.persistence.GenericDao;
import br.edu.fateczl.SpringAGIS.persistence.ProfessorDao;

@Controller
public class AulaController {
	
	@Autowired
	GenericDao gDao;
	
	@Autowired
	ProfessorDao pDao;
	
	@RequestMapping(name = "aula", value="/aula", method = RequestMethod.GET)
	public ModelAndView aulaGet (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String erro = "";
		List<Professor> professores = new ArrayList<>();
		
		try {
			professores = listarProfessores();	
		} catch(SQLException | ClassNotFoundException e){
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("professores", professores);
		}
		
		return new ModelAndView("aula");
	}
	

	@RequestMapping(name = "aula", value="/aula", method = RequestMethod.POST)
	public ModelAndView aulaPost (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		String professor = allRequestParam.get("professor");
		String disciplina = allRequestParam.get("disciplina");
		
		String saida = "";
		String erro = "";
		Professor p = new Professor();
		Disciplina d = new Disciplina();
		List<Disciplina> disciplinas = new ArrayList<>();
		List<Aluno> alunos = new ArrayList<>();
		
		return new ModelAndView("aula");
	}
	
	private List<Professor> listarProfessores() throws ClassNotFoundException, SQLException {
		return pDao.listar();
	}
}
