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
import br.edu.fateczl.SpringAGIS.model.Conteudo;
import br.edu.fateczl.SpringAGIS.model.Disciplina;
import br.edu.fateczl.SpringAGIS.model.Professor;
import br.edu.fateczl.SpringAGIS.persistence.AulaDao;
import br.edu.fateczl.SpringAGIS.persistence.ConteudoDao;
import br.edu.fateczl.SpringAGIS.persistence.DisciplinaDao;
import br.edu.fateczl.SpringAGIS.persistence.GenericDao;
import br.edu.fateczl.SpringAGIS.persistence.ProfessorDao;

@Controller
public class AulaController {
	
	@Autowired
	GenericDao gDao;
	
	@Autowired
	ProfessorDao pDao;
	
	@Autowired
	DisciplinaDao dDao;
	
	@Autowired
	AulaDao aDao;
	
	@Autowired
	ConteudoDao cDao;
	
	@RequestMapping(name = "aula", value="/aula", method = RequestMethod.GET)
	public ModelAndView aulaGet (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String erro = "";
		List<Disciplina> disciplinas = new ArrayList<>();
		
		try {
			disciplinas = listarDisciplinas();
		} catch(SQLException | ClassNotFoundException e){
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("disciplinas", disciplinas);
		}
		return new ModelAndView("aula");
	}
	

	private List<Disciplina> listarDisciplinas() throws ClassNotFoundException, SQLException {
		return dDao.listarDisciplinas();
	}


	@RequestMapping(name = "aula", value="/aula", method = RequestMethod.POST)
	public ModelAndView aulaPost (@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		String disciplina = allRequestParam.get("disciplina");
		String conteudo = allRequestParam.get("conteudo");
		
		String saida = "";
		String erro = "";
		boolean foundD = false;
		Disciplina d = new Disciplina();
		Conteudo c = new Conteudo();
		List<Aluno> alunos = new ArrayList<>();
		List<Conteudo> conteudos = new ArrayList<>();
		List<Disciplina> disciplinas = new ArrayList<>();
		
		try {
			disciplinas = listarDisciplinas();
			d.setCodigo(Integer.parseInt(disciplina));
			if(cmd.contains("Iniciar Gerenciamento")) {
				conteudos = listarConteudosDisciplina(d);
				foundD = true;
			}
			if(cmd.contains("Iniciar Chamada")) {
				alunos = listarAlunos(d);
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("conteudos", conteudos);
			model.addAttribute("disciplinas", disciplinas);
			model.addAttribute("disciplina", d);
			model.addAttribute("conteudo", c);
			model.addAttribute("alunos", alunos);
			model.addAttribute("foundD", foundD);
		}
		
		return new ModelAndView("aula");
	}
	
	private List<Conteudo> listarConteudosDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
		return cDao.listarPorDisciplina(d);
	}


	private List<Aluno> listarAlunos(Disciplina d) throws ClassNotFoundException, SQLException {
		return aDao.listarAlunos(d);
	}
}
