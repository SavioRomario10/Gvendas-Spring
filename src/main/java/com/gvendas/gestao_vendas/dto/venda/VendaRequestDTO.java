package com.gvendas.gestao_vendas.dto.venda;

import java.util.List;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Requisição de venda")
public class VendaRequestDTO {

  @Schema(description = "Data da venda")
  private LocalDate data;

  @Schema(description = "Itens da venda")
  private List<ItemVendaRequestDTO> itens;

  public LocalDate getData() {
    return data;
  }
  public void setData(LocalDate data) {
    this.data = data;
  }
  public List<ItemVendaRequestDTO> getItens() {
    return itens;
  }
  public void setItens(List<ItemVendaRequestDTO> itens) {
    this.itens = itens;
  }
}