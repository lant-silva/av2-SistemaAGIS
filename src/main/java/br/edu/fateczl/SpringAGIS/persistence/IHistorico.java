package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.SQLException;

public interface IHistorico {
	public void visualizarHistorico(String ra) throws SQLException, ClassNotFoundException;
}
