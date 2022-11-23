package br.edu.ifpe.agritec.model;



public enum Produto {
BANANA("BANANA"),
MACAXEIRA("MACAXEIRA"),
COENTRO("COENTRO"),
MANGA("MANGA"),
MELANCIA("MELANCIA"),
MAMAO("MAMAO"),
MAÇÃ("MAÇÃ"),
BATATA("BATATA"),
UVA("UVA"),
ARAÇÁ("ARAÇÁ"),
JAMBO("JAMBO"),
CARAMBOLA("CARAMBOLA"),
LARANJA("LARANJA"),
LIMÃO("LIMÃO"),
CARA("CARÁ"),
AZEITONA("AZEITONA"),
FRUTA_PAO("FRUTA PÃO"),
GOIABA("GOIABA"),
INHAME("INHAME"),
ACEROLA("ACEROLA"),
GRAVIOLA("GRAVIOLA"),
PITOMBA("PITOMBA"),
PINHA("PINHA"),
CEBOLA("CEBOLA"),
ALFACE("ALFACE"),
TOMATE("TOMATE"),
ABACAXI("ABACAXI");

private final String nome;

private Produto(String nome) {
this.nome = nome;

}

public static Produto fromUF(final String nome) {
for(final Produto uf : Produto.values()) {
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
