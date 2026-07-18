package com.gvendas.gestao_vendas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gvendas.gestao_vendas.entities.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long>{

  @Query(
    "SELECT new com.gvendas.gestao_vendas.entities.ItemVenda("
    +"iv.codigo, iv.quantidade, iv.precoVendido, iv.produto, iv.venda)"
    +" FROM ItemVenda iv"
    +" WHERE iv.venda.codigo = :codigoVenda")
  List<ItemVenda> findByVendaCodigo(Long codigo);
}