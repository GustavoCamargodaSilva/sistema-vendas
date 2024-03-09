package com.estoque.vendas.dto;

import com.estoque.vendas.entities.Venda;
import com.estoque.vendas.entities.VendaItem;
import com.estoque.vendas.enums.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO {

    private Long codVenda;
    private Instant dataVenda;
    private FormaPagamento formaPagamento;
    private Double valorTotal;

    private VendedorDTO vendedor;

    private ClienteDTO cliente;

    private List<VendaItem> vendaItems = new ArrayList<>();

    public VendaDTO(Venda entity) {
        codVenda = entity.getCodVenda();
        dataVenda = entity.getDataVenda();
        formaPagamento = entity.getFormaPagamento();
        vendedor = new VendedorDTO(entity.getVendedor());
        cliente = new ClienteDTO(entity.getCliente());
        vendaItems = new ArrayList<>(entity.getVendaItems());
    }
}
