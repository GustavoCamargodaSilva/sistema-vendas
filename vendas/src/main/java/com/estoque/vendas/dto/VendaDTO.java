package com.estoque.vendas.dto;

import com.estoque.vendas.entities.Cliente;
import com.estoque.vendas.entities.Venda;
import com.estoque.vendas.entities.VendaItem;
import com.estoque.vendas.entities.Vendedor;
import com.estoque.vendas.enums.FormaPagamento;
import com.estoque.vendas.enums.StatusVenda;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO {

    private Long codVenda;
    private Instant dataVenda;
    private StatusVenda statusVenda;
    private FormaPagamento formaPagamento;

    private VendedorDTO vendedor;

    private ClienteDTO cliente;

    private List<VendaItem> vendaItems = new ArrayList<>();

    public VendaDTO(Venda entity) {
        codVenda = entity.getCodVenda();
        dataVenda = entity.getDataVenda();
        statusVenda = entity.getStatusVenda();
        formaPagamento = entity.getFormaPagamento();
        vendedor = new VendedorDTO(entity.getVendedor());
        cliente = new ClienteDTO(entity.getCliente());
        vendaItems = new ArrayList<>(entity.getVendaItems());
    }
}
