package com.gvendas.gestao_vendas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestao_vendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestao_vendas.dto.venda.VendaRequestDTO;
import com.gvendas.gestao_vendas.service.VendaServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
  name = "Venda",
  description = "Sistema de vendas"
)
@RestController
@RequestMapping("/venda")
public class VendaController {

  private final VendaServico vendaServico;

  public VendaController(VendaServico vendaServico) {
    this.vendaServico = vendaServico;
  }

  @GetMapping("/cliente/{id}")
  @Operation(summary = "Listar vendas por cliente")
  public ResponseEntity<ClienteVendaResponseDTO> listarVendaPorCliente(@PathVariable("id") Long codigoCliente) {
    
    return ResponseEntity.ok(vendaServico.listaVendaPorCliente(codigoCliente));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Listar uma venda por id")
  public ResponseEntity<ClienteVendaResponseDTO> listarVendaPorId(@PathVariable("id") Long codigoVenda) {
    
    return ResponseEntity.ok(vendaServico.listarVendaPorCodigo(codigoVenda));
  }

  @PostMapping("/cliente/{id}")
  @Operation(summary = "Salvar uma venda")
  public ResponseEntity<ClienteVendaResponseDTO> salvar(@PathVariable("id") Long codigoCliente, @Valid @RequestBody VendaRequestDTO vendaDto) {

    return ResponseEntity.status(HttpStatus.CREATED).body(vendaServico.salvar(codigoCliente, vendaDto));
  } 

  @DeleteMapping("/{id}")
  @Operation(summary = "Deletar uma venda")
  public ResponseEntity<Void> deletar(@PathVariable("id")Long codigo){

    vendaServico.deletar(codigo);
    return ResponseEntity.noContent().build();
  }
}