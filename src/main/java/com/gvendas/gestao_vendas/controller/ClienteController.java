package com.gvendas.gestao_vendas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestao_vendas.dto.cliente.ClienteRequestDTO;
import com.gvendas.gestao_vendas.dto.cliente.ClienteResponseDTO;
import com.gvendas.gestao_vendas.entities.Cliente;
import com.gvendas.gestao_vendas.service.ClienteServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
  name = "Clientes",
  description = "Controlador de clientes"
)
@RestController
@RequestMapping("/cliente")
public class ClienteController {

  private final ClienteServico clienteServico;

  public ClienteController(ClienteServico clienteServico) {
    this.clienteServico = clienteServico;
  }

  @GetMapping
  @Operation(summary = "Listar todos")
  public List<ClienteResponseDTO> listarTodos(){
    return clienteServico.listarTodos().stream().map(ClienteResponseDTO::converter).toList();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Pesquisar por Id")
  public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable("id")Long codigo){
    Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigo);
    return cliente.isPresent() ? 
      ResponseEntity.ok(ClienteResponseDTO.converter(cliente.get())) : 
      ResponseEntity.notFound().build(); 
  }

  @PostMapping
  @Operation(summary = "Salvar um cliente")
  public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteDto){
    Cliente clienteSalvo = clienteServico.salvar(clienteDto.converter());
    return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponseDTO.converter(clienteSalvo));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Editar um cliente")
  public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable("id")Long codigo, @Valid @RequestBody ClienteRequestDTO clienteDto){
    Cliente atualizado = clienteServico.atualizar(codigo, clienteDto.converter());

    return ResponseEntity.ok(ClienteResponseDTO.converter(atualizado));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Deletar um cliente")
  public ResponseEntity<Void> deletar(@PathVariable("id")Long codigo){
    clienteServico.deletar(codigo);
    return ResponseEntity.noContent().build();
  }
}