package com.gvendas.gestao_vendas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestao_vendas.entities.Categoria;
import com.gvendas.gestao_vendas.service.CategoriaServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

  @Autowired
  private CategoriaServico categoriaServico;

  @GetMapping
  public List<Categoria> listarTodos(){
    return categoriaServico.listarTodos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable("id")Long codigo){
    Optional<Categoria> categoria = categoriaServico.buscarPorCodigo(codigo);
    return categoria.isPresent() ? 
      ResponseEntity.ok(categoria) : 
      ResponseEntity.notFound().build(); 
  }

  @PostMapping
  public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria){
    Categoria categoriaSalva = categoriaServico.salvar(categoria);
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(categoriaSalva);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Categoria> atualizar(@PathVariable("id") Long codigo, @Valid @RequestBody Categoria categoria){
    return ResponseEntity.ok(categoriaServico.atualizar(codigo, categoria));
  }
}