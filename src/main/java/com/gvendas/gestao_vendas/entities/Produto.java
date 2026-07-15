package com.gvendas.gestao_vendas.entities;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "codigo")
  private Long codigo;

  @Column(name = "descricao")
  @NotBlank(message = "descricao")
  @Length(min = 3, max = 50, message = "descrição")
  private String descricao;

  @Column(name = "quantidade")
  @NotNull(message = "quantidade")
  private Integer quantidade;

  @Column(name = "preco_custo")
  @NotNull(message = "Preço custo")
  private BigDecimal precoCusto;

  @Column(name = "preco_venda")
  @NotNull(message = "Preço Venda")
  private BigDecimal precoVenda;

  @Column(name = "observacao")
  @Length(max = 150, message = "Observação")
  private String observavao;

  @NotNull(message = "Categoria")
  @ManyToOne
  @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
  private Categoria categoria;

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

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
    result = prime * result + ((precoCusto == null) ? 0 : precoCusto.hashCode());
    result = prime * result + ((precoVenda == null) ? 0 : precoVenda.hashCode());
    result = prime * result + ((observavao == null) ? 0 : observavao.hashCode());
    result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Produto other = (Produto) obj;
    if (codigo == null) {
      if (other.codigo != null)
        return false;
    } else if (!codigo.equals(other.codigo))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (quantidade == null) {
      if (other.quantidade != null)
        return false;
    } else if (!quantidade.equals(other.quantidade))
      return false;
    if (precoCusto == null) {
      if (other.precoCusto != null)
        return false;
    } else if (!precoCusto.equals(other.precoCusto))
      return false;
    if (precoVenda == null) {
      if (other.precoVenda != null)
        return false;
    } else if (!precoVenda.equals(other.precoVenda))
      return false;
    if (observavao == null) {
      if (other.observavao != null)
        return false;
    } else if (!observavao.equals(other.observavao))
      return false;
    if (categoria == null) {
      if (other.categoria != null)
        return false;
    } else if (!categoria.equals(other.categoria))
      return false;
    return true;
  } 
}
