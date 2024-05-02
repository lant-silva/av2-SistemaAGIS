package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.SQLException;
import java.util.List;

public class ProfessorDao implements ICrud<Professor>, IIud<Professor>{
	private GenericDao gDao;
	
	public ProfessorDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public String iud(String acao, Professor t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor consultar(Professor t) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> listar() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
