package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringAGIS.model.Disciplina;

@Repository
public class DisciplinaDao implements IDisciplina{
	private GenericDao gDao;
	
	public DisciplinaDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public List<Disciplina> listarDisciplinas() throws SQLException, ClassNotFoundException {
		List<Disciplina> disciplinas = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM disciplina";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Disciplina d = new Disciplina();
			d.setCodigo(rs.getInt("codigo"));
			d.setNome(rs.getString("nome"));
			d.setDiaSemana(rs.getString("dia"));
			d.setHorarioInicio(rs.getString("horario_inicio"));
			d.setHorarioFim(rs.getString("horario_final"));
			d.setCursoCodigo(rs.getInt("curso_codigo"));
			d.setQtdAulas(rs.getInt("qtd_aulas"));
			d.setProfessorCodigo(rs.getInt("codigo_professor"));
			disciplinas.add(d);
		}
		rs.close();
		ps.close();
		c.close();
		return disciplinas; 
	}
}
