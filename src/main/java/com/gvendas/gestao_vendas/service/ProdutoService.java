package com.gvendas.gestao_vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvendas.gestao_vendas.entities.Produto;
import com.gvendas.gestao_vendas.repository.ProdutoRepository;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private CategoriaServico categoriaServico;

  public List<Produto> listarTodos(Long codigoCategoria){
    return produtoRepository.findByCategoriaCodigo(codigoCategoria);
  }

  public Optional<Produto> buscarPorId(Long codigo, Long codigoCategoria){
    return produtoRepository.buscarPorCodigo(codigo, codigoCategoria);
  }

  public Produto salvar(Long codigoCategoria, Produto produto){
    validarCategoria(codigoCategoria);
    validarProdutoDuplicado(produto);
    return produtoRepository.save(produto);
  }

  public Produto atualizar(Long codigoCategoria, Long codigoProduto, Produto produto){
    Produto produtoSalvar = validarProdutoExiste(codigoCategoria, codigoProduto);
    validarCategoria(codigoCategoria);
    validarProdutoDuplicado(produto);
    BeanUtils.copyProperties(produto, produtoSalvar, "codigo");
    return produtoRepository.save(produtoSalvar);
  }

  public void deletar(Long codigoCategoria, Long codigoProduto){
    Produto produto = validarProdutoExiste(codigoCategoria, codigoProduto);

    produtoRepository.delete(produto);
  }

  private Produto validarProdutoExiste(Long codigoCategoria, Long codigoPorduto){
    Optional<Produto> produto = buscarPorId(codigoPorduto, codigoCategoria);
    if (produto.isEmpty()) {
      throw new IllegalArgumentException();
    }
    return produto.get();
  }

  private void validarProdutoDuplicado(Produto produto){
    Optional<Produto> produtoDescricao = produtoRepository.findByCategoriaCodigoAndDescricao(produto.getCategoria().getCodigo(), produto.getDescricao());
    
    if(produtoDescricao.isPresent() && produtoDescricao.get().getCodigo() != produto.getCodigo()){
      throw new IllegalArgumentException(); 
    }
  }

  private void validarCategoria(Long codigoCategoria){
    if(codigoCategoria == null){
      throw new IllegalArgumentException(); 
    }
    if(categoriaServico.buscarPorCodigo(codigoCategoria).isEmpty()){
      throw new IllegalArgumentException();
    }
  }
}