package com.gvendas.gestao_vendas.dto.venda;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representação de um cliente e suas vendas")
public class ClienteVendaResponseDTO {

  @Schema(description = "Nome do cliente")
  private String nome;

  @Schema(description = "Vendas do cliente")
  private List<VendaResponseDTO> vendas;

  public ClienteVendaResponseDTO() {}

  public ClienteVendaResponseDTO(String nome, List<VendaResponseDTO> vendas) {
    this.nome = nome;
    this.vendas = vendas;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public List<VendaResponseDTO> getVendas() {
    return vendas;
  }
  public void setVendas(List<VendaResponseDTO> vendas) {
    this.vendas = vendas;
  }
}