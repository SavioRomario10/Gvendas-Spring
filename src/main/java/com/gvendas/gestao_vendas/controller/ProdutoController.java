package com.gvendas.gestao_vendas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestao_vendas.entities.Produto;
import com.gvendas.gestao_vendas.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
  name = "Produto",
  description = "Operações relacionadas aos produtos"
)
@RestController
@RequestMapping("/categoria/{codigoCategoria}/produto")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @GetMapping
  @Operation(summary = "Listar todos")
  public List<Produto> listarTodos(@PathVariable Long codigoCategoria){
    return produtoService.listarTodos(codigoCategoria);
  }

  @GetMapping("/{codigo}")
  @Operation(summary = "Buscar por Id")
  public ResponseEntity<Optional<Produto>> buscarPorId(
    @PathVariable Long codigoCategoria, @PathVariable Long codigo){
    
    Optional<Produto> produto = produtoService.buscarPorId(codigo, codigoCategoria);

    return produto.isPresent() ? 
      ResponseEntity.ok(produto) :
      ResponseEntity.notFound().build();
  }

  @PostMapping
  @Operation(summary = "Salvar um produto")
  public ResponseEntity<Produto> salvar(@PathVariable Long codigoCategoria, @Valid @RequestBody Produto produto){
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(produtoService.salvar(codigoCategoria, produto));
  }

  @PutMapping("/{codigoProduto}")
  @Operation(summary = "Atualizar um produto")
  public ResponseEntity<Produto> atualizar(
    @PathVariable Long codigoCategoria, 
    @PathVariable Long codigoProduto, 
    @Valid @RequestBody Produto produto){

    return ResponseEntity.ok(produtoService.atualizar(codigoCategoria, codigoProduto, produto));
  }
  
  @DeleteMapping("/{codigoProduto}")
  @Operation(summary = "Deletar um produto")
  public ResponseEntity<Void> deletar(
    @PathVariable Long codigoCategoria, 
    @PathVariable Long codigoProduto){
    
    produtoService.deletar(codigoCategoria, codigoProduto);

    return ResponseEntity.noContent().build();
  }
}