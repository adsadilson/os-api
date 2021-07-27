package br.com.apssystem.os.domain.enums;

public enum Prioridade {

	BAIXA("BAIXA"), 
	MEDIA("MEDIA"), 
	ALTA("ALTA");

	private String descricao;

	Prioridade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
