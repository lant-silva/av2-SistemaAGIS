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
public class DispensaController {
	
	@Autowired
	GenericDao gDao;
	
	@Autowired
	AlunoDao aDao;
	
	@Autowired
	DisciplinaDao dDao;
	
	@RequestMapping(name="dispensa", value="/dispensa", method = RequestMethod.GET)
	public ModelAndView dispensaGet(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		
		return new ModelAndView("dispensa");
	}
	
	@RequestMapping(name="dispensa", value="/dispensa", method = RequestMethod.POST)
	public ModelAndView dispensaPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		String ra = allRequestParam.get("ra");
		
		String saida = "";
		String erro = "";
		boolean found = false;
		Aluno a = new Aluno();
		Disciplina d = new Disciplina();
		List<Disciplina> disciplinas = new ArrayList<>();
		
		try {
			if(cmd.contains("Consultar Aluno")) {
				a.setRa(ra);
				a = buscarAluno(a);				
				disciplinas = listarDisciplinas(ra);
				found = true;
			}
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("disciplinas", disciplinas);
			model.addAttribute("disciplina", d);
			model.addAttribute("aluno", a);
			model.addAttribute("found", found);
		}
		return new ModelAndView("dispensa");
	}

	private Aluno buscarAluno(Aluno a) throws ClassNotFoundException, SQLException {
		a = aDao.consultar(a);
		return a;
	}

	private List<Disciplina> listarDisciplinas(String ra) throws ClassNotFoundException, SQLException {
		return dDao.listarDisciplinasPorAluno(ra);
	}
}
