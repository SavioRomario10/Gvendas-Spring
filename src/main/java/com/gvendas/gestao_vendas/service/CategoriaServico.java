package com.gvendas.gestao_vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestao_vendas.entities.Categoria;
import com.gvendas.gestao_vendas.repository.CategoriaRepository;

@Service
public class CategoriaServico {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public List<Categoria> listarTodos(){
    return categoriaRepository.findAll();
  }

  public Optional<Categoria> buscarPorCodigo(Long codigo){
    return categoriaRepository.findById(codigo);
  }

  public Categoria salvar(Categoria categoria){
    return categoriaRepository.save(categoria);
  }

  public Categoria atualizar(Long codigo, Categoria categoria){
    Categoria categoriaSalvar = validarCategoria(codigo);

    BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");

    return categoriaRepository.save(categoriaSalvar);
  }

  private Categoria validarCategoria(Long codigo){
    Optional<Categoria> categoria = buscarPorCodigo(codigo);

    if(categoria.isEmpty()){
      throw new EmptyResultDataAccessException(1);
    }

    return categoria.get();
  }
}