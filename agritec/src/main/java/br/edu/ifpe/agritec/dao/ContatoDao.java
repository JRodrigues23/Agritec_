package br.edu.ifpe.agritec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.agritec.model.Agricultores;
import br.edu.ifpe.agritec.model.Contato;

import java.util.ArrayList;


@Repository
public class ContatoDao {
	//ADCIONA NO BANCO DA DADOS
		public void adcionarContato(Contato contato) throws ClassNotFoundException, SQLException{
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `contato`"
				+ "( `nome` ,`email`, `mensagem`) "
				+ " VALUES (? , ? , ? , ?)";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getMensagem());
		
		stmt.execute();

		stmt.close();
		connection.close();
		
		} 
	
		//CONSULTA 
		public List<Contato> colsultarTodosContatos() throws ClassNotFoundException, SQLException{
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "SELECT `idcontato`,  `nome`, `email`, `mensagem`  FROM `contato`";

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultSet = stmt.executeQuery();
			
			List<Contato> listaTodosContatos = new ArrayList<Contato>();
			
			while(resultSet.next()) {
			Contato contato = new Contato(0, sql, sql, sql);
				
				int idcontato = resultSet.getInt("idcontato");
				contato.setIdcontato(idcontato);
			
				String nome = resultSet.getString(2);
				contato.setNome(nome);
				String email = resultSet.getString(3);
				contato.setEmail(email);
				contato.setMensagem(resultSet.getNString(4));
				
				
				listaTodosContatos.add(contato);
				
			}
			stmt.close();
			connection.close();
			
			return listaTodosContatos;
		}
			
		
}
