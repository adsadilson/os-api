package br.com.apssystem.os.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apssystem.os.domain.entity.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Long>{

}
