package com.gvendas.gestao_vendas.dto.produto;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.Length;

import com.gvendas.gestao_vendas.entities.Categoria;
import com.gvendas.gestao_vendas.entities.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Requisição de produto")
public class ProdutoRequestDto {

  @Schema(description = "Descrição do produto")
  @NotBlank(message = "descricao")
  @Length(min = 3, max = 50, message = "descrição")
  private String descricao;

  @Schema(description = "Quantidade do produto")
  @NotNull(message = "quantidade")
  private Integer quantidade;

  @Schema(description = "Preço de custo do produto")
  @NotNull(message = "Preço custo")
  private BigDecimal precoCusto;

  @Schema(description = "Preço de venda do produto")
  @NotNull(message = "Preço Venda")
  private BigDecimal precoVenda;

  @Schema(description = "Observação do produto")
  @Length(max = 150, message = "Observação")
  private String observavao;

  public Produto converter(Long codigoCategoria) {
    return new Produto(descricao, quantidade, precoCusto, precoVenda, observavao, new Categoria(codigoCategoria));
  }

  public Produto converter(Long codigoCategoria, Long codigoProduto) {
    return new Produto(codigoProduto,descricao, quantidade, precoCusto, precoVenda, observavao, new Categoria(codigoCategoria));
  }

  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public Integer getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
  public BigDecimal getPrecoCusto() {
    return precoCusto;
  }
  public void setPrecoCusto(BigDecimal precoCusto) {
    this.precoCusto = precoCusto;
  }
  public BigDecimal getPrecoVenda() {
    return precoVenda;
  }
  public void setPrecoVenda(BigDecimal precoVenda) {
    this.precoVenda = precoVenda;
  }
  public String getObservavao() {
    return observavao;
  }
  public void setObservavao(String observavao) {
    this.observavao = observavao;
  }
}