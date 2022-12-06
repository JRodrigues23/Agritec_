package br.edu.ifpe.agritec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.agritec.model.Agricultores;

import java.util.ArrayList;

@Repository

public class AgricultoresDao {
	
	//ADCIONA NO BANCO DE DADOS
	public void adcionarAgricultores(Agricultores agricultores) throws ClassNotFoundException, SQLException{
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
	String sql = "INSERT INTO `agricultores`"
			+ "( `cpf`,  `nome` ,`email`,`foto`,`produtoproduzido`) "
			+ " VALUES (? , ? , ? , ? , ?)";
	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	stmt.setString(1, agricultores.getCpf());
	stmt.setString(2, agricultores.getNome());
	stmt.setString(3, agricultores.getEmail());
	stmt.setByte(4, agricultores.getFoto());
	stmt.setString(5, agricultores.getProdutoproduzido());
	
	stmt.execute();

	stmt.close();
	connection.close();
	
	} 

	//CONSULTA 
	public List<Agricultores> colsultarTodosAgricultores() throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idAgri`,  `cpf`, `nome`, `email`,`foto`, `produtoproduzido` FROM `agricultores`";

		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet resultSet = stmt.executeQuery();
		
		List<Agricultores> listaTodosAgricultores = new ArrayList<Agricultores>();
		
		while(resultSet.next()) {
		Agricultores agricultores = new Agricultores();
			
			int idAgri = resultSet.getInt("idAgri");
			agricultores.setIdagri(idAgri);
		
			String cpf = resultSet.getString(2);
			agricultores.setCpf(cpf);
			
			String nome = resultSet.getString(3);
			agricultores.setNome(nome);
			
			String email = resultSet.getString(4);
			agricultores.setEmail(email);
			agricultores.setFoto(resultSet.getByte(5));
			agricultores.setProdutoproduzido(resultSet.getString(6));
			
			listaTodosAgricultores.add(agricultores);
			
		}
		stmt.close();
		connection.close();
		
		return listaTodosAgricultores;
	}
	
	//CONSULTA  
		public Agricultores colsultarAgricultoresId(int idagri) throws ClassNotFoundException, SQLException{
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "SELECT `idAgri`,  `cpf`, `nome`, `email`,`foto`, `produtoproduzido` FROM `agricultores` WHERE idagri=?";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idagri);
			
			ResultSet resultSet = stmt.executeQuery();
			
			Agricultores agricultores = new Agricultores();
			
			if(resultSet.next()) {
				
				int idAgri = resultSet.getInt("idAgri");
				agricultores.setIdagri(idAgri);
			
				String cpf = resultSet.getString(2);
				agricultores.setCpf(cpf);
				String nome = resultSet.getString(3);
				agricultores.setNome(nome);
				agricultores.setEmail(resultSet.getString(4));
				agricultores.setFoto(resultSet.getByte(5));
				agricultores.setProdutoproduzido(resultSet.getString(6));
				
				
			}
			stmt.close();
			connection.close();
			
			return agricultores;
		}
	//ATUALIZAR
	public void atualizarAgricultores(Agricultores agricultores) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		
		String sql = "UPDATE `agricultores` SET `cpf`=?,`nome`=? WHERE `idAgri` = ? ";
		
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		

		stmt.setString(1, agricultores.getCpf());
		stmt.setString(2, agricultores.getNome());
//		stmt.setString(3, cliente.getCidade());
//		stmt.setString(4, cliente.getUf());
		stmt.setInt(3, agricultores.getIdagri());
		
		
		
		stmt.executeUpdate();
		stmt.close();
		connection.close();
		
	}
	
	//DELETAR
	public void deletarAgricultores(int idagri) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql= "DELETE from `agricultores` where `idAgri`=?";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
		stmt.setInt(1,  idagri);
		stmt.executeUpdate();
		stmt.close();
		connection.close();		
		
	}

	public void saveAndFlush(Agricultores agricultores) {
		// TODO Auto-generated method stub
		
	}

	public Agricultores getOne(Integer foto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
	
