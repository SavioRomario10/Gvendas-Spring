package com.gvendas.gestao_vendas.dto.cliente;

import com.gvendas.gestao_vendas.dto.cliente.endereco.EnderecoResponseDTO;
import com.gvendas.gestao_vendas.entities.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representa um cliente")
public class ClienteResponseDTO {

  @Schema(description = "Código do cliente")
  private Long codigo;
  
  @Schema(description = "Nome do cliente")
  private String nome;

  @Schema(description = "Telefone do cliente")
  private String telefone;

  @Schema(description = "Ativo do cliente")
  private Boolean ativo;

  private EnderecoResponseDTO endereco;

  public ClienteResponseDTO() {}
  public ClienteResponseDTO(Long codigo, String nome, String telefone, Boolean ativo, EnderecoResponseDTO endereco) {
    this.codigo = codigo;
    this.nome = nome;
    this.telefone = telefone;
    this.ativo = ativo;
    this.endereco = endereco;
  }

  public static ClienteResponseDTO converter(Cliente cliente){

    return new ClienteResponseDTO(
      cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getAtivo(), EnderecoResponseDTO.converter(cliente.getEndereco()));
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
  
  
}