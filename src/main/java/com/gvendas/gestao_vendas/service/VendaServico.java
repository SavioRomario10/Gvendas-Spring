package com.gvendas.gestao_vendas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gvendas.gestao_vendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestao_vendas.dto.venda.ItemVendaRequestDTO;
import com.gvendas.gestao_vendas.dto.venda.VendaRequestDTO;
import com.gvendas.gestao_vendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestao_vendas.entities.Cliente;
import com.gvendas.gestao_vendas.entities.ItemVenda;
import com.gvendas.gestao_vendas.entities.Produto;
import com.gvendas.gestao_vendas.entities.Venda;
import com.gvendas.gestao_vendas.repository.ItemVendaRepository;
import com.gvendas.gestao_vendas.repository.VendaRepository;

@Service
public class VendaServico extends AbstractVendaServico{

  private final ClienteServico clienteServico;
  private final VendaRepository vendaRepository;
  private final ItemVendaRepository itemVendaRepository;
  private final ProdutoService produtoService;

  @Autowired
  public VendaServico(ClienteServico clienteServico, VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository, ProdutoService produtoService) {
    this.clienteServico = clienteServico;
    this.vendaRepository = vendaRepository;
    this.itemVendaRepository = itemVendaRepository;
    this.produtoService = produtoService;
  }

  public ClienteVendaResponseDTO listaVendaPorCliente(Long codigoCliente){
    Cliente validarExiste = validarClienteExiste(codigoCliente);

    List<VendaResponseDTO> vendas = vendaRepository.findByClienteCodigo(codigoCliente).stream().map(
      venda -> criandoVenda(venda, itemVendaRepository.findByVendaCodigo(venda.getCodigo()))
    ).collect(Collectors.toList());

    return new ClienteVendaResponseDTO(validarExiste.getNome(), vendas);
  }

  public ClienteVendaResponseDTO listarVendaPorCodigo(Long codigoVenda){
    
    Venda vendaExiste = validarVendaExiste(codigoVenda);

    List<ItemVenda> itensVenda = itemVendaRepository.findByVendaCodigo(vendaExiste.getCodigo());

    return retornandoClienteVenda(vendaExiste, itensVenda);
  }
  
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  public ClienteVendaResponseDTO salvar(Long codigoCliente, VendaRequestDTO vendaDto){

    Cliente cliente = validarClienteExiste(codigoCliente);
    validarProdutoExiste(vendaDto.getItens());

    Venda vendaSalva = salvarVenda(cliente, vendaDto);
    List<ItemVenda> itemVendas = itemVendaRepository.findByVendaCodigo(vendaSalva.getCodigo());

    return retornandoClienteVenda(vendaSalva, itemVendas);
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  public void deletar(Long codigoVenda){
    Venda venda = validarVendaExiste(codigoVenda);
    List<ItemVenda> itemVenda = itemVendaRepository.findByVendaCodigo(codigoVenda);

    devolverProduto(venda, itemVenda);
    itemVendaRepository.deleteAll(itemVenda);
    vendaRepository.delete(venda);
  }

  private void devolverProduto(Venda venda , List<ItemVenda> itensVenda){
    itensVenda.forEach(item -> {
      Produto produto = produtoService.validarProdutoExiste(item.getProduto().getCodigo());
      produto.setQuantidade(produto.getQuantidade()+item.getQuantidade());
      produtoService.atualizarQuantidadeVenda(produto);
    });
  }

  private Venda salvarVenda(Cliente cliente, VendaRequestDTO vendaDto){
    Venda vendaSalva = vendaRepository.save(new Venda(vendaDto.getData(), cliente));

    vendaDto.getItens().stream().map(item -> criandoItem(item, vendaSalva)).forEach(itemVendaRepository::save);

    return vendaSalva;
  }

  private void validarProdutoExiste(List<ItemVendaRequestDTO> itens){
    itens.forEach(item -> {
      Produto produto = produtoService.validarProdutoExiste(item.getCodigoProduto());
      validarQuantidadeProduto(produto, item.getQuantidade());
      produto.setQuantidade(produto.getQuantidade()-item.getQuantidade());

      produtoService.atualizarQuantidadeVenda(produto);
    }); 
  }

  private void validarQuantidadeProduto(Produto produto, Integer quantidade){
    if(produto.getQuantidade() <= quantidade)
      throw new RuntimeException("Quantidade insuficiente");
  }

  private Venda validarVendaExiste(Long codigo){
    
    Optional<Venda> venda = vendaRepository.findById(codigo);

    if(venda.isEmpty())
      throw new RuntimeException("Venda nao encontrada");

    return venda.get();
  }

  private Cliente validarClienteExiste(Long codigo){
    
    Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigo);

    if(cliente.isEmpty())
      throw new RuntimeException("Cliente nao encontrado");

    return cliente.get();
  }
}