package com.gvendas.gestao_vendas.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.gvendas.gestao_vendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestao_vendas.dto.venda.ItemVendaRequestDTO;
import com.gvendas.gestao_vendas.dto.venda.ItemVendaResponseDTO;
import com.gvendas.gestao_vendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestao_vendas.entities.ItemVenda;
import com.gvendas.gestao_vendas.entities.Produto;
import com.gvendas.gestao_vendas.entities.Venda;

public abstract class AbstractVendaServico {
  protected ClienteVendaResponseDTO retornandoClienteVenda(Venda venda, List<ItemVenda> itensVenda){

    return new ClienteVendaResponseDTO(venda.getCliente().getNome(), Arrays.asList(criandoVenda(venda, itensVenda)));
  }
  protected ItemVenda criandoItem(ItemVendaRequestDTO itemVendaDto, Venda venda){
    return new ItemVenda(itemVendaDto.getQuantidade(), itemVendaDto.getPrecoVenda(), new Produto(itemVendaDto.getCodigoProduto()), venda);
  }

 protected VendaResponseDTO criandoVenda(Venda venda, List<ItemVenda> itensVendaList){
    
    List<ItemVendaResponseDTO> itens = itensVendaList.stream().map(this::criandoItemVenda).collect(Collectors.toList());

    return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itens);
  }

  protected ItemVendaResponseDTO criandoItemVenda(ItemVenda itemVenda){
    
    return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(), itemVenda.getProduto().getCodigo(), itemVenda.getProduto().getDescricao());
  }
}