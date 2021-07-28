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

import br.com.apssystem.os.api.dtos.entity.TecnicoEntity;
import br.com.apssystem.os.api.dtos.input.TecnicoInput;
import br.com.apssystem.os.api.dtos.mapper.TecnicoMapper;
import br.com.apssystem.os.domain.entity.Tecnico;
import br.com.apssystem.os.domain.service.TecnicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags = "Tecnico")
@RestController
@RequestMapping("/tecnicos")
@AllArgsConstructor
public class TecnicoResource {

	private TecnicoService tecnicoService;
	private TecnicoMapper mapper;

	@ApiOperation("Cadasta uma tecnico")
	@PostMapping
	public ResponseEntity<Tecnico> adicionar(@RequestBody Tecnico obj) {
		obj = tecnicoService.adicionar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation("Atualizar uma tecnico")
	@PutMapping("/{id}")
	public ResponseEntity<TecnicoEntity> update(@RequestBody TecnicoInput input, @PathVariable Long id) {
		Tecnico entity = tecnicoService.buscarPorId(id);
		mapper.copyToDomainObject(input, entity);
		tecnicoService.autalizar(entity);
		return ResponseEntity.ok().body(mapper.toEntity(entity));
	}

	@ApiOperation("Excluir um tecnico")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		tecnicoService.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation("Pesquisar tecnico por ID")
	@GetMapping("/{id}")
	public ResponseEntity<TecnicoEntity> buscarPorId(@PathVariable Long id) {
		Tecnico obj = tecnicoService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Listar todos os clientes")
	@GetMapping
	public ResponseEntity<List<TecnicoEntity>> listarTodos() {
		List<Tecnico> list = tecnicoService.findAll();
		return ResponseEntity.ok(mapper.toCollectionEntity(list));
	}

}
