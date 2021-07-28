package br.com.apssystem.os.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.apssystem.os.api.exception.EntidadeEmUsoException;
import br.com.apssystem.os.api.exception.EntidadeNaoEncontradaException;
import br.com.apssystem.os.api.exception.NegocioException;
import br.com.apssystem.os.domain.entity.Cliente;
import br.com.apssystem.os.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

	private ClienteRepository clienteRepository;

	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException("Cliente não encontrada para esse [ID: " + id + "]"));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Transactional
	public Cliente adicionar(Cliente obj) {
		clienteExistente(obj);
		return clienteRepository.save(obj);
	}

	private void clienteExistente(Cliente obj) {
		boolean result = clienteRepository.findByCpf(obj.getCpf()).stream().anyMatch(cpf -> !cpf.equals(obj));
		if (result)
			throw new NegocioException("Cliente já cadastrado para esse [CPF: " + obj.getCpf() + "]");
	}

	@Transactional
	public Cliente autalizar(Cliente obj) {
		return clienteRepository.save(obj);
	}

	public void excluir(Long id) {
		buscarPorId(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Cliente não pode ser deletado! possui associação com outras tabelas");
		}
	}
}
