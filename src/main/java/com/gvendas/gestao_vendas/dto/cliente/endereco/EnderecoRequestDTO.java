package com.gvendas.gestao_vendas.dto.cliente.endereco;

import org.hibernate.validator.constraints.Length;

import com.gvendas.gestao_vendas.entities.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Endereço do cliente")
public class EnderecoRequestDTO {

  @Schema(description = "Logradouro do endereço do cliente")
  @NotBlank(message = "logradouro") 
  @Length(min = 3, max = 50, message = "logradouro")
  private String logradouro;

  @Schema(description = "Número do endereço do cliente")
  @NotNull(message = "numero")
  private Integer numero;

  @Schema(description = "Complemento do endereço do cliente")
  @Length(max = 50, message = "complemento")
  private String complemento;

  @Schema(description = "Bairro do endereço do cliente")
  @NotBlank(message = "bairro")
  @Length(min = 3, max = 50, message = "bairro")
  private String bairro;

  @Schema(description = "CEP do endereço do cliente")
  @NotBlank(message = "cep")
  @Pattern(regexp = "\\d{8}", message = "cep")
  private String cep;

  @Schema(description = "Cidade do endereço do cliente")
  @NotBlank(message = "cidade")
  @Length(min = 3, max = 50, message = "cidade")
  private String cidade;
  
  @Schema(description = "Estado do endereço do cliente")
  @NotBlank(message = "estado")
  @Length(min = 3, max = 50, message = "estado")
  private String estado;

  public EnderecoRequestDTO() {}
  public EnderecoRequestDTO(String logradouro, Integer numero, String complemento, String bairro, String cep,
      String cidade, String estado) {
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
  }

  public Endereco converter() {
    return new Endereco(logradouro, numero, complemento, bairro, cep, cidade, estado);
  }

  public String getLogradouro() {
    return logradouro;
  }
  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }
  public Integer getNumero() {
    return numero;
  }
  public void setNumero(Integer numero) {
    this.numero = numero;
  }
  public String getComplemento() {
    return complemento;
  }
  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }
  public String getBairro() {
    return bairro;
  }
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  public String getCep() {
    return cep;
  }
  public void setCep(String cep) {
    this.cep = cep;
  }
  public String getCidade() {
    return cidade;
  }
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
  public String getEstado() {
    return estado;
  }
  public void setEstado(String estado) {
    this.estado = estado;
  }
}