package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.SpringAGIS.model.Disciplina;

public interface IHistorico {
	public void visualizarHistorico(String ra) throws SQLException, ClassNotFoundException;

	public List<Disciplina> popularDisciplinas(String ra) throws SQLException, ClassNotFoundException;
	
}
