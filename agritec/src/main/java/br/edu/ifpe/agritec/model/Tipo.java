package br.edu.ifpe.agritec.model;

public enum Tipo {
	FRUTA("Fruta"),
	LEGUME("Legume"),
	VERDURA("Verdura"),
	VEGETAIS("Vegetais");
	
	
	
	
	private final String nome;

	private Tipo(String nome) {
	this.nome = nome;

	}

	public static Tipo fromUF(final String nome) {
	for(final Tipo uf : Tipo.values()) {
	if(uf.nome.equalsIgnoreCase(nome)) {
	return uf;
	}
	}

	throw new IllegalArgumentException(nome);
	}



	public String getNome() {
	return nome;
	
}
}
