package com.gvendas.gestao_vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gvendas.gestao_vendas.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
  Cliente findByNome(String nome);
}