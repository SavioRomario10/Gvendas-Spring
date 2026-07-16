package com.gvendas.gestao_vendas.dto.produto;

import java.math.BigDecimal;
import com.gvendas.gestao_vendas.entities.Produto;
import com.gvendas.gestao_vendas.dto.categoria.CategoriaResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
  name = "ProdutoResponseDTO",
  description = "Informações do produto"
)
public class ProdutoResponseDTO {

  @Schema(description = "Código do produto")
  private Long codigo;

  @Schema(description = "Descrição do produto")
  private String descricao;

  @Schema(description = "Quantidade do produto")
  private Integer quantidade;

  @Schema(description = "Preço de custo do produto")
  private BigDecimal precoCusto;

  @Schema(description = "Preço de venda do produto")
  private BigDecimal precoVenda;

  @Schema(description = "Observação do produto")
  private String observavao;

  @Schema(description = "Categoria do produto")
  private CategoriaResponseDTO categoria;

  public ProdutoResponseDTO() {}

  public ProdutoResponseDTO(Long codigo, String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda, String observavao, CategoriaResponseDTO categoria) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.quantidade = quantidade;
    this.precoCusto = precoCusto;
    this.precoVenda = precoVenda;
    this.observavao = observavao;
    this.categoria = categoria;
  }

  public static ProdutoResponseDTO converter(Produto produto) {
    return new ProdutoResponseDTO(
      produto.getCodigo(),
      produto.getDescricao(),
      produto.getQuantidade(),
      produto.getPrecoCusto(),
      produto.getPrecoVenda(),
      produto.getObservavao(),
      CategoriaResponseDTO.converter(produto.getCategoria())
    );
  }
  
  public Long getCodigo() {
    return codigo;
  }
  public void setCodigo(Long codigo) {
    this.codigo = codigo;
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
  public CategoriaResponseDTO getCategoria() {
    return categoria;
  }
  public void setCategoria(CategoriaResponseDTO categoria) {
    this.categoria = categoria;
  }
}