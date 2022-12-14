package br.edu.ifpe.agritec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Repository;

import br.edu.ifpe.agritec.model.Agricultores;
import br.edu.ifpe.agritec.model.Alimentos;

@Repository
public class AlimentosDao {
//ADICIONAR AO BANCO DE DADOS
	public void adicionarAlimentos(Alimentos alimentos ) throws ClassNotFoundException, SQLException, ParseException{
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
	String sql = "INSERT INTO `alimentos` "
			+ "( `nome`, `dataDeValidade`, `dataDeColheita`, `tipo`)"
			+ " VALUES (? , ? , ? , ?) ";
	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
		
	stmt.setString(1, alimentos.getNome());	
	stmt.setString(2, alimentos.getDataDeColheita());
	stmt.setString(3, alimentos.getDataDeValidade());
	stmt.setString(4, alimentos.getTipo());
		
	stmt.execute();
	stmt.close();
		
	connection.close();

	} 
	//CONSULTA
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
	
	
	//Consulta
	public Alimentos colsultarAlimentosId(int idalimentos) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idAlimentos`, `nome`, `dataDeValidade`, `dataDeColheita`, `tipo` FROM `alimentos` WHERE idAlimentos=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, idalimentos);
		
		ResultSet resultSet = stmt.executeQuery();
		
		Alimentos alimentos = new Alimentos();
		
		if(resultSet.next()) {
			
			int idAlimentos = resultSet.getInt("idAlimentos");
			alimentos.setIdAlimentos(idAlimentos);
		
			String nome = resultSet.getString(2);
			alimentos.setNome(nome);
			String dataDeValidade = resultSet.getString(3);
			alimentos.setDataDeValidade(dataDeValidade);
			alimentos.setDataDeColheita(resultSet.getString(4));
			alimentos.setTipo(resultSet.getString(5));
			
		}
		stmt.close();
		connection.close();
		
		return alimentos;
	}
	//ATUALIZAR
	public void atualizarAlimentos(Alimentos alimentos) throws  ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "UPDATE `alimentos` SET `nome`=?, `dataDeValidade`=?, `dataDeColheita`=?, `tipo`=? WHERE `idAlimentos`=?";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
		stmt.setString(1, alimentos.getNome());
		stmt.setString(2, alimentos.getDataDeValidade());
		stmt.setString(3, alimentos.getDataDeColheita());
		stmt.setString(4, alimentos.getTipo());
		stmt.setInt(5, alimentos.getIdAlimentos());
		
		stmt.executeUpdate();
		stmt.close();
		connection.close();
		

	}
	
	//DELETE
	public void deletarAlimentos(int idAlimentos)  throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql= "DELETE from `alimentos` where `idAlimentos`=?";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
		stmt.setInt(1, idAlimentos);
		stmt.executeUpdate();
		stmt.close();
		connection.close();		
		
		

		
	}
	
	
	
	
}
