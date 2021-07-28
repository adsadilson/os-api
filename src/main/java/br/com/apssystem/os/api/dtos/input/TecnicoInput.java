package br.com.apssystem.os.api.dtos.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class TecnicoInput {

	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String nome;
	
	@NotNull
	@CPF
	private String cpf;
	
	@Size(max = 25)
	private String telefone;
}
