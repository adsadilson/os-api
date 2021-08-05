package br.com.apssystem.os.api.dtos.input;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.apssystem.os.api.dtos.input.ids.ClienteIdInput;
import br.com.apssystem.os.api.dtos.input.ids.TecnicoIdInput;
import br.com.apssystem.os.domain.enums.Prioridade;
import lombok.Data;

@Data
public class OSInput {
	
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;

	@NotNull
	private Prioridade prioridade;

	private String observacoes;

	@NotNull
	private TecnicoIdInput tecnico;

	@NotNull
	private ClienteIdInput cliente;

}
