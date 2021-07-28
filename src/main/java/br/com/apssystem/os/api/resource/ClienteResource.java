package br.com.apssystem.os.api.resource;

import java.net.URI;
import java.util.List;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteResource {

	private ClienteService clienteService;
	private ClienteMapper mapper;

	@ApiOperation("Pesquisar cliente por ID")
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> buscarPorId(@PathVariable Long id) {
		Cliente obj = clienteService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Atualizar uma cliente")
	@PutMapping("/{id}")
	public ResponseEntity<ClienteEntity> update(@RequestBody ClienteInput input, @PathVariable Long id) {
		Cliente entity = clienteService.buscarPorId(id);
		mapper.copyToDomainObject(input, entity);
		clienteService.autalizar(entity);
		return ResponseEntity.ok().body(mapper.toEntity(entity));
	}

	@ApiOperation("Listar todos os clientes")
	@GetMapping
	public ResponseEntity<List<ClienteEntity>> listarTodos() {
		List<Cliente> list = clienteService.findAll();
		return ResponseEntity.ok(mapper.toCollectionEntity(list));
	}

	@ApiOperation("Cadasta uma cliente")
	@PostMapping
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente obj) {
		obj = clienteService.adicionar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation("Excluir um cliente por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
