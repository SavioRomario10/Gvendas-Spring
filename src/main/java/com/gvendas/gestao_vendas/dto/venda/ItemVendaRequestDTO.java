package com.gvendas.gestao_vendas.dto.venda;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Itens da venda")
public class ItemVendaRequestDTO {
  
  @Schema(description = "Código do produto")
  @NotNull(message = "codigoProduto")
  private Long codigoProduto;

  @Schema(description = "Quantidade")
  @NotNull(message = "quantidade")
  @Min(value = 1, message = "quantidade")
  private Integer quantidade;

  @Schema(description = "Preço de venda")
  @NotNull(message = "precoVenda")
  private BigDecimal precoVenda;

  public ItemVendaRequestDTO() {}
  public ItemVendaRequestDTO( Long codigoProduto, Integer quantidade, BigDecimal precoVenda) {
    this.codigoProduto = codigoProduto;
    this.quantidade = quantidade;
    this.precoVenda = precoVenda;
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
  public Integer getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
}