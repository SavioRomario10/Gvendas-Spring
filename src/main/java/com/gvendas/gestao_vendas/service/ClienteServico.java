package com.gvendas.gestao_vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.gvendas.gestao_vendas.entities.Cliente;
import com.gvendas.gestao_vendas.repository.ClienteRepository;

@Service
public class ClienteServico {

  private final ClienteRepository clienteRepository;

  public ClienteServico(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

    public List<Cliente> listarTodos(){
    return clienteRepository.findAll();
  }

  public Optional<Cliente> buscarPorCodigo(Long codigo){
    return clienteRepository.findById(codigo.longValue());
  }

  public Cliente salvar(Cliente cliente){
    validarCliente(cliente);
    return clienteRepository.save(cliente);
  }

  public Cliente atualizar(Long codigo, Cliente cliente){
    Cliente clienteAtualizar = validarExiste(codigo);
    validarCliente(cliente);

    BeanUtils.copyProperties(cliente, clienteAtualizar, "codigo");

    return clienteRepository.save(clienteAtualizar);
  }

  public void deletar(Long codigo){
    validarExiste(codigo);
    clienteRepository.deleteById(codigo.longValue());
  }

  private void validarCliente(Cliente cliente){
    Cliente byNome = clienteRepository.findByNome(cliente.getNome());

    if(byNome != null && byNome.getCodigo() != cliente.getCodigo()){
      throw new RuntimeException("Ja existe um cliente com esse nome");
    }
  }
  
  private Cliente validarExiste(Long codigo){
    Optional<Cliente> cliente = buscarPorCodigo(codigo);
    
    if(cliente.isEmpty()){
      throw new RuntimeException("Cliente nao encontrado");
    }
    
    return cliente.get();
  }
}