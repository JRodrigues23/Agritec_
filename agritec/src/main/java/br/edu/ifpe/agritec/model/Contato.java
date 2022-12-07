package br.edu.ifpe.agritec.model;

import javax.persistence.Lob;

public class Contato {
	private int idcontato;
	private String nome;
	private String email;
	private String mensagem;
	
	
	
	public Contato(int idcontato, String nome, String email, String mensagem) {
	super();
	this.idcontato = idcontato;
	this.nome = nome;
	this.email = email;
	this.mensagem = mensagem;
	
	}
	
	
	public int getIdcontato() {
		return idcontato;
	}
	public void setIdcontato(int idcontato) {
		this.idcontato = idcontato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}


