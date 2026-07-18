package com.gvendas.gestao_vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gvendas.gestao_vendas.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

  List<Venda> findByClienteCodigo(Long codigo);
}