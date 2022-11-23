package br.edu.ifpe.agritec.model;

public class Agricultores {
	private int idagri;
	private String cpf;
	private String nome;
	private String email;
	private String produtoproduzido;

	public Agricultores() {
		super();
	}
	public Agricultores(int idagri, String cpf, String nome, String email, String produtoproduzido) {
	super();
	this.idagri = idagri;
	this.cpf = cpf;
	this.nome = nome;
	this.email = email;
	this.produtoproduzido = produtoproduzido;
	
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
	

}
