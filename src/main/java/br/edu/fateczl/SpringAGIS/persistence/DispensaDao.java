package br.edu.fateczl.SpringAGIS.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringAGIS.model.Aluno;
import br.edu.fateczl.SpringAGIS.model.Disciplina;

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
	
}
