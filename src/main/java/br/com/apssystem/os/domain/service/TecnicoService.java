package br.com.apssystem.os.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.apssystem.os.api.exception.EntidadeEmUsoException;
import br.com.apssystem.os.api.exception.EntidadeNaoEncontradaException;
import br.com.apssystem.os.api.exception.NegocioException;
import br.com.apssystem.os.domain.entity.Tecnico;
import br.com.apssystem.os.domain.repository.TecnicoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TecnicoService {

	private TecnicoRepository tecnicoRepository;

	@Transactional
	public Tecnico adicionar(Tecnico obj) {
		clienteExistente(obj);
		return tecnicoRepository.save(obj);
	}

	@Transactional
	public Tecnico autalizar(Tecnico obj) {
		return tecnicoRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			tecnicoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Tecnico não pode ser deletado! possui associação com outras tabelas");
		}
	}

	public Tecnico buscarPorId(Long id) {
		return tecnicoRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException("Tecnico não encontrada para esse [ID: " + id + "]"));
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

	private void clienteExistente(Tecnico obj) {
		boolean result = tecnicoRepository.findByCpf(obj.getCpf()).stream().anyMatch(cpf -> !cpf.equals(obj));
		if (result)
			throw new NegocioException("Tecnico já cadastrado para esse [CPF: " + obj.getCpf() + "]");
	}
}
