package br.edu.ifpe.agritec.model;

import javax.persistence.Lob;

public class Agricultores {
	private int idagri;
	private String cpf;
	private String nome;
	private String email;
	private String produtoproduzido;
	private String foto;

	
	public Agricultores(int idagri, String cpf, String nome, String email, String produtoproduzido, String foto) {
	super();
	this.idagri = idagri;
	this.cpf = cpf;
	this.nome = nome;
	this.email = email;
	this.produtoproduzido = produtoproduzido;
	this.foto = foto;
	}
	
	public Agricultores() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdagri() {
		return idagri;
	}
	public void setIdagri(int idagri) {
		this.idagri = idagri;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getProdutoproduzido() {
		return produtoproduzido;
	}
	public void setProdutoproduzido(String produtoproduzido) {
		this.produtoproduzido = produtoproduzido;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	

}
