package br.com.apssystem.os.api.dtos.entity;

import lombok.Data;

@Data
public class TecnicoEntity {

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
}
