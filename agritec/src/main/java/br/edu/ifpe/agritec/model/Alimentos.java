package br.edu.ifpe.agritec.model;

public class Alimentos {
	private int idAlimentos;
	private String nome;
	private String dataDeValidade;	
	private String dataDeColheita;
	private String tipo;
	
	
	
	
	public int getIdAlimentos() {
		return idAlimentos;
	}
	public void setIdAlimentos(int idAlimentos) {
		this.idAlimentos = idAlimentos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataDeValidade() {
		return dataDeValidade;
	}
	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	public String getDataDeColheita() {
		return dataDeColheita;
	}
	public void setDataDeColheita(String dataDeColheita) {
		this.dataDeColheita = dataDeColheita;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public static Object values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
