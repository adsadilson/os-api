package br.com.apssystem.os.domain.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.apssystem.os.domain.enums.Prioridade;
import br.com.apssystem.os.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "os")
@SequenceGenerator(name = "OS_ID", sequenceName = "OS_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "OS_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;

	@Enumerated(EnumType.STRING)
	private Prioridade prioridade;

	private String observacoes;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	private Tecnico tecnico;

	@ManyToOne
	private Cliente cliente;

}
