package br.com.apssystem.os.domain.enums;

import lombok.Getter;

@Getter
public enum Status {

	ATIVO("ATIVO"), 
	INATIVO("INATIVO");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

}
