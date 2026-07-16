package com.gvendas.gestao_vendas.dto.categoria;

import com.gvendas.gestao_vendas.entities.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Categoria retorno DTO")
public class CategoriaResponseDTO {

  @Schema(description = "Código da categoria")
  private Long codigo;

  @Schema(description = "Nome da categoria")
  private String nome;

  public CategoriaResponseDTO() {}
  public CategoriaResponseDTO(Long codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }

  public static CategoriaResponseDTO converter(Categoria categoria) {
    return new CategoriaResponseDTO(categoria.getCodigo(), categoria.getNome());
  }

  public Long getCodigo() {
    return codigo;
  }
  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
}