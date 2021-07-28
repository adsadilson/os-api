package br.com.apssystem.os.api.dtos.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.apssystem.os.domain.enums.Prioridade;
import br.com.apssystem.os.domain.enums.Status;
import lombok.Data;

@Data
public class OSEntity {

	private Long id;
	private LocalDate dataAbertura;
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private String observacoes;
	private Status status;
	
	@JsonIgnoreProperties({"cpf","telefone"})
	private TecnicoEntity tecnico;

	@JsonIgnoreProperties({"cpf","telefone"})
	private ClienteEntity cliente;

}
