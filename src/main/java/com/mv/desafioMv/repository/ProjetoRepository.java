package com.mv.desafioMv.repository;

import com.mv.desafioMv.model.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjetoRepository extends JpaRepository<Projetos, Long> {

    Optional<Projetos> findByCodigo(String codigo);
}
