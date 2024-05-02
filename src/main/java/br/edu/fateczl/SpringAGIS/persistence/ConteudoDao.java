package br.edu.fateczl.SpringAGIS.persistence;

public class ConteudoDao {
	private GenericDao gDao;
	
	public ConteudoDao(GenericDao gDao) ICrud<Conteudo>{
		this.gDao = gDao;
	}
	
	
}
