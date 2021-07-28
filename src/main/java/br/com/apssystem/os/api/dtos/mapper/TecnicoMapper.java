package br.com.apssystem.os.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.apssystem.os.api.dtos.entity.TecnicoEntity;
import br.com.apssystem.os.api.dtos.input.TecnicoInput;
import br.com.apssystem.os.domain.entity.Tecnico;

@Component
public class TecnicoMapper {

	@Autowired
	private ModelMapper modelMapper;

	public TecnicoEntity toEntity(Tecnico obj) {
		return modelMapper.map(obj, TecnicoEntity.class);
	}

	public List<TecnicoEntity> toCollectionEntity(List<Tecnico> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public Tecnico toDomain(TecnicoInput input) {
		return modelMapper.map(input, Tecnico.class);
	}

	public void copyToDomainObject(TecnicoInput input, Tecnico obj) {
		modelMapper.map(input, obj);
	}

}
