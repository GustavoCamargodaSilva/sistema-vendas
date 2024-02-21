package com.estoque.vendas.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_venda_item")
public class VendaItem {

    @EmbeddedId
    private VendaItemPK id = new VendaItemPK();

    private Integer quantidade;
    private Double preco;
    private Double desconto;

    public VendaItem(Venda venda, Produto produto, Integer quantidade, Double preco, Double desconto) {
        id.setVenda(venda);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public Venda getVenda() {
        return id.getVenda();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public void setVenda(Venda venda) {
        id.setVenda(venda);
    }

}
