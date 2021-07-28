package br.com.apssystem.os.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apssystem.os.domain.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findByCpf(String cpf);

}
