package com.gvendas.gestao_vendas.dto.venda;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Itens da venda")
public class ItemVendaResponseDTO {

  @Schema(description = "Código")
  private Long codigo;
  @Schema(description = "Quantidade")
  private Integer quantidade;

  @Schema(description = "Preço de venda")
  private BigDecimal precoVenda;

  @Schema(description = "Código do produto")
  private Long codigoProduto;

  @Schema(description = "Descrição do produto")
  private String produtoDescricao;

  public ItemVendaResponseDTO() {}

  public ItemVendaResponseDTO(Long codigo, Integer quantidade, BigDecimal precoVenda, Long codigoProduto, String produtoDescricao) {
    this.codigo = codigo;
    this.quantidade = quantidade;
    this.precoVenda = precoVenda;
    this.codigoProduto = codigoProduto;
    this.produtoDescricao = produtoDescricao;
  }

  public Long getCodigo() {
    return codigo;
  }
  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }
  public Integer getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
  public BigDecimal getPrecoVenda() {
    return precoVenda;
  }
  public void setPrecoVenda(BigDecimal precoVenda) {
    this.precoVenda = precoVenda;
  }
  public Long getCodigoProduto() {
    return codigoProduto;
  }
  public void setCodigoProduto(Long codigoProduto) {
    this.codigoProduto = codigoProduto;
  }
  public String getProdutoDescricao() {
    return produtoDescricao;
  }
}