package br.edu.ifpe.agritec.model;

public enum ProdutoProduzido {
	BANANA("Fruta"),
	MAÇã("Fruta"),
	BATATA_INGLESA("Legume"),
	COENTRO("Hortaliça"),
	UVA("Fruta"),
	Macaxeira("Legume");

	private final String tipo;

	private ProdutoProduzido(String tipo) {
		this.tipo = tipo;
		
	}
	public static ProdutoProduzido fromProdutoProduzido(final String tipo) {
		for(final ProdutoProduzido produtoproduzido : ProdutoProduzido.values()) {
			if(produtoproduzido.tipo.equalsIgnoreCase(tipo)) {
				return produtoproduzido;
			}
		}
		throw new IllegalArgumentException(tipo);
		
	}
	public String getTipo() {
		return tipo;
	}
	
}
