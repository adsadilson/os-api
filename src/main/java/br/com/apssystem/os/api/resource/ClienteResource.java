package br.com.apssystem.os.api.resource;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.apssystem.os.api.dtos.entity.ClienteEntity;
import br.com.apssystem.os.api.dtos.input.ClienteInput;
import br.com.apssystem.os.api.dtos.mapper.ClienteMapper;
import br.com.apssystem.os.domain.entity.Cliente;
import br.com.apssystem.os.domain.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteResource {

	private ClienteService clienteService;
	private ClienteMapper mapper;

	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> buscarPorId(@PathVariable Long id) {
		Cliente obj = clienteService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteEntity> update(@RequestBody ClienteInput input, @PathVariable Long id) {
		Cliente entity = clienteService.buscarPorId(id);
		mapper.copyToDomainObject(input, entity);
		clienteService.autalizar(entity);
		return ResponseEntity.ok().body(mapper.toEntity(entity));
	}

	@PostMapping
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente obj) {
		obj = clienteService.adicionar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
