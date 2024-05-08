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
import br.edu.fateczl.SpringAGIS.model.Dispensa;
import br.edu.fateczl.SpringAGIS.persistence.AlunoDao;
import br.edu.fateczl.SpringAGIS.persistence.DisciplinaDao;
import br.edu.fateczl.SpringAGIS.persistence.DispensaDao;
import br.edu.fateczl.SpringAGIS.persistence.GenericDao;

@Controller
public class SecretariaDispensaController {
	
	@Autowired
	GenericDao gDao;
	
	@Autowired
	AlunoDao aDao;
	
	@Autowired
	DisciplinaDao dDao;
	
	@Autowired
	DispensaDao dispDao;
	
	@RequestMapping(name="secretariadispensa", value="/secretariadispensa", method = RequestMethod.GET)
	public ModelAndView secretariaDispensaGet(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String erro = "";
		List<Dispensa> dispensas = new ArrayList<>();
		try {
			dispensas = listarDispensas(dispensas);
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("dispensas", dispensas);
		}
		return new ModelAndView("secretariadispensa");
	}
	

	private List<Dispensa> listarDispensas(List<Dispensa> dispensas) throws ClassNotFoundException, SQLException {
		dispensas = dispDao.listar();
		return dispensas;
	}


	@RequestMapping(name="secretariadispensa", value="/secretariadispensa", method = RequestMethod.POST)
	public ModelAndView secretariaDispensaPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		String cmd = allRequestParam.get("botao");
		String aprovacao = allRequestParam.get("aprovacao");
		String ra = allRequestParam.get("ra");
		String disciplina = allRequestParam.get("disciplina");
		List<Dispensa> dispensas = new ArrayList<>();
		Aluno a = new Aluno();
		Disciplina d = new Disciplina();
		
		
		String saida = "";
		String erro = "";
		
		if(Integer.parseInt(aprovacao) == 1) {
			aprovacao = "Aprovar";
		}else {
			aprovacao = "Recusar";
		}
		
		try {
			if(cmd.contains("Concluir")) {
				saida = concluirDispensa(ra, disciplina, aprovacao);
				// depois disso, atualizar as requisições remanescentes ne :D
				dispensas = listarDispensas(dispensas);
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("dispensas", dispensas);
		}
		
		return new ModelAndView("secretariadispensa");
	}
	
	private String concluirDispensa(String ra, String disciplina, String aprovacao) throws ClassNotFoundException, SQLException {
		return dispDao.concluirDispensa(ra, disciplina, aprovacao);
	}


	private List<Dispensa> atualizarDispensas(Aluno a, Disciplina d) throws ClassNotFoundException, SQLException {
		return dispDao.atualizarLista(a, d);
	}
}
