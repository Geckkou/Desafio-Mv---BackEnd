package com.mv.desafioMv.repository;

import com.mv.desafioMv.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByCnpjIgnoreCaseContaining(String cnpj);
}