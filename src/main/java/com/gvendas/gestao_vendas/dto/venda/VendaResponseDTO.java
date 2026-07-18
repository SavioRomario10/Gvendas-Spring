package com.gvendas.gestao_vendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Venda")
public class VendaResponseDTO {

  @Schema(description = "Código da venda")
  private Long codigo;
  
  @Schema(description = "Data da venda")
  private LocalDate data;

  @Schema(description = "Itens da venda")
  private List<ItemVendaResponseDTO> itens;

  public VendaResponseDTO() {}
  public VendaResponseDTO(Long codigo, LocalDate data, List<ItemVendaResponseDTO> itens) {
    this.codigo = codigo;
    this.data = data;
    this.itens = itens;
  }

  public Long getCodigo() {
    return codigo;
  }
  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }
  public LocalDate getData() {
    return data;
  }
  public void setData(LocalDate data) {
    this.data = data;
  }
  public List<ItemVendaResponseDTO> getItens() {
    return itens;
  }
  public void setItens(List<ItemVendaResponseDTO> itens) {
    this.itens = itens;
  }
}
