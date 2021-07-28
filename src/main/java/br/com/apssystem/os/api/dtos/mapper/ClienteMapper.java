package br.com.apssystem.os.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.apssystem.os.api.dtos.entity.ClienteEntity;
import br.com.apssystem.os.api.dtos.input.ClienteInput;
import br.com.apssystem.os.domain.entity.Cliente;

@Component
public class ClienteMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ClienteEntity toEntity(Cliente obj) {
		return modelMapper.map(obj, ClienteEntity.class);
	}

	public List<ClienteEntity> toCollectionEntity(List<Cliente> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Cliente toDomain(ClienteInput input) {
		return modelMapper.map(input, Cliente.class);
	}

	public void copyToDomainObject(ClienteInput input, Cliente obj) {
		modelMapper.map(input, obj);
	}

}
