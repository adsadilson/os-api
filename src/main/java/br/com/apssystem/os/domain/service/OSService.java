package br.com.apssystem.os.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.apssystem.os.api.exception.EntidadeEmUsoException;
import br.com.apssystem.os.api.exception.EntidadeNaoEncontradaException;
import br.com.apssystem.os.domain.entity.OS;
import br.com.apssystem.os.domain.repository.OSRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OSService {

	private OSRepository osRepository;

	@Transactional
	public OS adicionar(OS obj) {
		return osRepository.save(obj);
	}

	@Transactional
	public OS autalizar(OS obj) {
		return osRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			osRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("OS não pode ser deletada! possui associação com outras tabelas");
		}
	}

	public OS buscarPorId(Long id) {
		return osRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("OS não encontrada para esse [ID: " + id + "]"));
	}

	public List<OS> findAll() {
		return osRepository.findAll();
	}
}
