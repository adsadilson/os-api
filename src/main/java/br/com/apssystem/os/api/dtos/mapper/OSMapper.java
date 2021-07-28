package br.com.apssystem.os.api.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.apssystem.os.api.dtos.entity.OSEntity;
import br.com.apssystem.os.api.dtos.input.OSInput;
import br.com.apssystem.os.domain.entity.OS;

@Component
public class OSMapper {

	@Autowired
	private ModelMapper modelMapper;

	public OSEntity toEntity(OS obj) {
		return modelMapper.map(obj, OSEntity.class);
	}

	public List<OSEntity> toCollectionEntity(List<OS> objs) {
		return objs.stream().map(obj -> toEntity(obj)).collect(Collectors.toList());
	}

	public OS toDomain(OSInput input) {
		return modelMapper.map(input, OS.class);
	}

	public void copyToDomainObject(OSInput input, OS obj) {
		modelMapper.map(input, obj);
	}

}
