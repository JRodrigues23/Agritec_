package br.edu.ifpe.agritec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.agritec.model.Alimentos;

@Repository
public class AlimentosDao {

	public void adicionarAlimentos(Alimentos alimentos ) throws ClassNotFoundException, SQLException{
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `alimentos`"
				+"( `nome`, `dataDeValidade`, `dataDeColheita`, `tipo`)"
				+" VALUES ('?','?','?','?')";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, alimentos.getNome());
		stmt.setString(2, alimentos.getDataDeValidade());
		stmt.setString(3, alimentos.getDataDeColheita());
		stmt.setString(4, alimentos.getTipo());
		
		stmt.execute();
		stmt.close();
		connection.close();

	}
	
	public List<Alimentos> consultarTodosAlimentos() throws  ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idAlimentos`, `nome`, `dataDeValidade`, `dataDeColheita`, `tipo` FROM `alimentos`";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
		ResultSet resultSet = stmt.executeQuery();

		List<Alimentos> listarTodosAlimentos = new ArrayList<Alimentos>();
		
		while(resultSet.next()) {
			Alimentos alimentos = new Alimentos();
			
			int idAlimentos = resultSet.getInt("idAlimentos");
			alimentos.setIdAlimentos(idAlimentos);
			String nome = resultSet.getString(2);
			alimentos.setNome(nome);
			String dataDeValidade = resultSet.getString(3);
			alimentos.setDataDeValidade(dataDeValidade);
			alimentos.setDataDeColheita(resultSet.getString (4));
			alimentos.setTipo(resultSet.getString(5));
			
			listarTodosAlimentos.add(alimentos);
			
		}
		
		stmt.close();
		connection.close();
		
		return listarTodosAlimentos;
		
	}
	
	
}
