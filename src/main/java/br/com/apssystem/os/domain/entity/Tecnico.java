package br.com.apssystem.os.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Tecnico extends Pessoa {

	@OneToMany(mappedBy = "tecnico")
	private List<OS> list = new ArrayList<>();
	
	public List<OS> getList() {
		return list;
	}
	
	public void setList(List<OS> list) {
		this.list = list;
	}
}
