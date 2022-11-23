package br.edu.ifpe.agritec.model;



public enum UnidadeFederacao {
BANANA("BANANA","AC","Rio Branco"),
MACAXEIRA("MACAXEIRA","AL", "Maceió"),
COENTRO("COENTRO","AP","Macapá"),
MANGA("MANGA","AM","Manaus"),
MELANCIA("MELANCIA","BA","Salvador"),
MAMAO("MAMAO", "CE","Fortaleza"),
MAÇÃ("MAÇÃ","ES","Vitória"),
BATATA("BATATA","GO","Goiânia"),
UVA("UVA","MA","São Luís"),
ARAÇÁ("ARAÇÁ","MT","Cuiabá"),
JAMBO("JAMBO","MS","Campo Grande"),
CARAMBOLA("CARAMBOLA","MG","Belo Horizonte"),
LARANJA("LARANJA","PA","Belém"),
LIMÃO("LIMÃO","PB","João Pessoa"),
CARA("CARÁ","PR","Curitiba"),
AZEITONA("AZEITONA","PE","Recife"),
FRUTA_PAO("FRUTA PÃO","PI","Teresina"),
GOIABA("GOIABA","RJ","Rio de Janeiro"),
INHAME("INHAME","RN", "Natal"),
ACEROLA("ACEROLA","RS","Porto Alegre"),
GRAVIOLA("GRAVIOLA","RO","Porto Velho"),
PITOMBA("PITOMBA","RR", "Boa Vista"),
PINHA("PINHA","SC","Florianópolis"),
CEBOLA("CEBOLA","SP","São Paulo"),
ALFACE("ALFACE","SE","Aracaju"),
TOMATE("TOMATE","TO","Palmas"),
ABACAXI("ABACAXI","uf","brasilia");

private final String nome;
private final String sigla;
private final String capital;

private UnidadeFederacao(String nome, String sigla, String capital) {
this.nome = nome;
this.sigla = sigla;
this.capital = capital;
}

public static UnidadeFederacao fromUF(final String nome) {
for(final UnidadeFederacao uf : UnidadeFederacao.values()) {
if(uf.nome.equalsIgnoreCase(nome)) {
return uf;
}
}

throw new IllegalArgumentException(nome);
}


public static UnidadeFederacao fromCapital(final String capital) {
for(final UnidadeFederacao uf : UnidadeFederacao.values()) {
if(uf.capital.equalsIgnoreCase(capital)) {
return uf;
}
}
throw new IllegalArgumentException(capital);

}

public static UnidadeFederacao fromSigla(final String sigla) {
for(final UnidadeFederacao uf : UnidadeFederacao.values()) {
if(uf.sigla.equalsIgnoreCase(sigla)) {
return uf;
}
}
throw new IllegalArgumentException(sigla);
}

public String getNome() {
return nome;
}

public String getSigla() {
return sigla;
}

public String getCapital() {
return capital;
}




}
