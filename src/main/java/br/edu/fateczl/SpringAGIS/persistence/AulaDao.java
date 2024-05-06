package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.SpringAGIS.model.Aluno;
import br.edu.fateczl.SpringAGIS.model.Disciplina;

public class AulaDao implements IAula{
	private GenericDao gDao;
	
	public AulaDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public List<Aluno> listarAlunos(Disciplina d) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
	}
	
	
}
