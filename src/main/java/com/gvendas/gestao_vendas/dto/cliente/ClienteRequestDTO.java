package com.gvendas.gestao_vendas.dto.cliente;

import org.hibernate.validator.constraints.Length;

import com.gvendas.gestao_vendas.dto.cliente.endereco.EnderecoRequestDTO;
import com.gvendas.gestao_vendas.entities.Cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Requisição de cliente")
public class ClienteRequestDTO {

  @Schema(description = "Nome do cliente")
  @NotBlank(message = "nome")
  @Length(min = 3, max = 50, message = "nome")
  private String nome;

  @Schema(description = "Telefone do cliente")
  @NotBlank(message = "telefone")
  @Pattern(regexp = "\\d{11}", message = "telefone")
  private String telefone;

  @Schema(description = "Ativo do cliente")
  @NotNull(message = "ativo")
  private Boolean ativo;

  @Schema(description = "Endereço do cliente")
  @NotNull(message = "endereco")
  @Valid
  private EnderecoRequestDTO endereco;

  public ClienteRequestDTO() {}
  public ClienteRequestDTO(String nome, String telefone, Boolean ativo, EnderecoRequestDTO endereco) {
    this.nome = nome;
    this.telefone = telefone;
    this.ativo = ativo;
    this.endereco = endereco;
  }

  public Cliente converter() {
    return new Cliente(this.nome, this.telefone, this.ativo, this.endereco.converter());
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getTelefone() {
    return telefone;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
  public Boolean getAtivo() {
    return ativo;
  }
  public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
  }
  public EnderecoRequestDTO getEndereco() {
    return endereco;
  }
  public void setEndereco(EnderecoRequestDTO endereco) {
    this.endereco = endereco;
  }
}