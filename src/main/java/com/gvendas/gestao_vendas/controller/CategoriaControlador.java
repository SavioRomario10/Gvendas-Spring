package com.gvendas.gestao_vendas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestao_vendas.dto.categoria.CategoriaRequestDTO;
import com.gvendas.gestao_vendas.dto.categoria.CategoriaResponseDTO;
import com.gvendas.gestao_vendas.entities.Categoria;
import com.gvendas.gestao_vendas.service.CategoriaServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
  name = "Categoria",
  description = "Operações relacionadas às categorias"
)
@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

  private final CategoriaServico categoriaServico;

  CategoriaControlador(CategoriaServico categoriaServico) {
    this.categoriaServico = categoriaServico;
  }

  @GetMapping
  @Operation(summary = "Listar todos")
  public List<CategoriaResponseDTO> listarTodos(){
    return categoriaServico.listarTodos().stream().map(CategoriaResponseDTO::converter).toList();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Pesquisar por Id")
  public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable("id")Long codigo){
    Optional<Categoria> categoria = categoriaServico.buscarPorCodigo(codigo);
    return categoria.isPresent() ? 
      ResponseEntity.ok(CategoriaResponseDTO.converter(categoria.get())) : 
      ResponseEntity.notFound().build(); 
  }

  @PostMapping
  @Operation(summary = "Salvar nova Categoria")
  public ResponseEntity<CategoriaResponseDTO> salvar(@Valid @RequestBody CategoriaRequestDTO categoria){
    Categoria categoriaSalva = categoriaServico.salvar(categoria.converter());
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(CategoriaResponseDTO.converter(categoriaSalva));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Editar uma Categoria")
  public ResponseEntity<CategoriaResponseDTO> atualizar(@PathVariable("id") Long codigo, @Valid @RequestBody CategoriaRequestDTO categoriaDto){

    Categoria atualizar = categoriaServico.atualizar(codigo, categoriaDto.converter(codigo));

    return ResponseEntity.ok(CategoriaResponseDTO.converter(atualizar));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Deletar uma Categoria")
  public ResponseEntity<Void> delete(@PathVariable("id") Long codigo){
    categoriaServico.deletar(codigo);

    return ResponseEntity.noContent().build();
  }
}