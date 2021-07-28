package br.com.apssystem.os.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apssystem.os.domain.entity.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{

	Optional<Tecnico> findByCpf(String cpf);

}
