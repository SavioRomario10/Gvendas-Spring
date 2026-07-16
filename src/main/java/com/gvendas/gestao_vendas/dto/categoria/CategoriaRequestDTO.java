package com.gvendas.gestao_vendas.dto.categoria;

import org.hibernate.validator.constraints.Length;
import com.gvendas.gestao_vendas.entities.Categoria;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
  name = "CategoriaRequestDTO",
  description = "CategoriaRequestDTO"
)
public class CategoriaRequestDTO {

  @NotBlank(message = "Nome da categoria")
  @Length(min = 3, max = 50, message = "nome")
  private String nome;

  public CategoriaRequestDTO() {}
  public CategoriaRequestDTO(String nome) {
    this.nome = nome;
  }

  public Categoria converter() {
    return new Categoria(this.nome);
  }
    public Categoria converter(Long codigo) {
    return new Categoria(codigo, this.nome);
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
}