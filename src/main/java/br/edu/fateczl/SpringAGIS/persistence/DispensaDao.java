package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringAGIS.model.Aluno;
import br.edu.fateczl.SpringAGIS.model.Disciplina;
import br.edu.fateczl.SpringAGIS.model.Dispensa;

@Repository
public class DispensaDao {
	private GenericDao gDao;
	
	public DispensaDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	public String enviarSolicitacaoDispensa(Aluno a, Disciplina d, String motivo) throws SQLException, ClassNotFoundException{
		Connection c = gDao.getConnection();
		String sql = "CALL sp_alunodispensa(?,?,?,?)";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, a.getRa());
		cs.setInt(2, d.getCodigo());
		cs.setString(3, motivo);
		cs.registerOutParameter(4, Types.VARCHAR);
		cs.execute();
		String saida = cs.getString(4);
		cs.close();
		c.close();
		return saida;
	}
	
	public List<Dispensa> listar() throws SQLException, ClassNotFoundException{
		List<Dispensa> dispensas = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM v_dispensas";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Dispensa d = new Dispensa();
			Aluno a = new Aluno();
			a.setRa(rs.getString("aluno_ra"));
			d.setAluno(a);
			Disciplina dd = new Disciplina();
			dd.setCodigo(rs.getInt("codigo_disciplina"));
			d.setDisciplina(dd);
			d.setMotivo(rs.getString("motivo"));
			dispensas.add(d);
		}
		rs.close();
		ps.close();
		c.close();
		return dispensas;
	}
}
