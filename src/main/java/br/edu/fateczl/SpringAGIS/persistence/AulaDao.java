package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringAGIS.model.Aluno;
import br.edu.fateczl.SpringAGIS.model.Disciplina;

@Repository
public class AulaDao implements IAula{
	private GenericDao gDao;
	
	public AulaDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public List<Aluno> listarAlunos(Disciplina d) throws SQLException, ClassNotFoundException {
		List<Aluno> alunos = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM v_aluno_chamada WHERE codigo_disciplina = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, d.getCodigo());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Aluno a = new Aluno();
			a.setRa(rs.getString("ra"));
			a.setNome(rs.getString("nome"));
			alunos.add(a);
		}
		rs.close();
		ps.close();
		c.close();
		return alunos;
	}	
}
