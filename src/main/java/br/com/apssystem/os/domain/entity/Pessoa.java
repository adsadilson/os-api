package br.com.apssystem.os.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "PESSOA_ID", sequenceName = "PESSOA_ID_SEQ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PESSOA_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@EqualsAndHashCode.Include
	@Column(nullable = false, length = 14)
	@CPF
	private String cpf;

	@Column(length = 25)
	private String telefone;

}
