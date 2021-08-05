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

import br.com.apssystem.os.api.dtos.entity.OSEntity;
import br.com.apssystem.os.api.dtos.input.OSInput;
import br.com.apssystem.os.api.dtos.mapper.OSMapper;
import br.com.apssystem.os.domain.entity.OS;
import br.com.apssystem.os.domain.service.OSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags = "OS")
@RestController
@RequestMapping("/os")
@AllArgsConstructor
public class OSResource {

	private OSService osService;
	private OSMapper mapper;

	@ApiOperation("Pesquisar os por ID")
	@GetMapping("/{id}")
	public ResponseEntity<OSEntity> buscarPorId(@PathVariable Long id) {
		OS obj = osService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toEntity(obj));
	}

	@ApiOperation("Atualizar uma os")
	@PutMapping("/{id}")
	public ResponseEntity<OSEntity> atualizar(@RequestBody OSInput input) {
		OS entity = osService.buscarPorId(input.getId());
		mapper.copyToDomainObject(input, entity);
		osService.autalizar(entity);
		return ResponseEntity.ok().body(mapper.toEntity(entity));
	}

	@ApiOperation("Listar todos os oss")
	@GetMapping
	public ResponseEntity<List<OSEntity>> listarTodos() {
		List<OS> list = osService.findAll();
		return ResponseEntity.ok(mapper.toCollectionEntity(list));
	}

	@ApiOperation("Cadasta uma os")
	@PostMapping
	public ResponseEntity<OS> adicionar(@RequestBody OS obj) {
		obj = osService.adicionar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation("Excluir um os por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		osService.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
