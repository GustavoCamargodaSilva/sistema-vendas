package com.estoque.vendas.entities;

import com.estoque.vendas.dto.EstoqueFilialDTO;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_estoque_filial")
@Getter
@Setter
public class EstoqueFilial {

    @EmbeddedId
    private EstoqueFilialPK id = new EstoqueFilialPK();

    @Getter
    private Integer quantidadeEstoque;

    public EstoqueFilial(Filial filial, Produto produto, Integer quantidadeEstoque) {
        id.setFilial(filial);
        id.setProduto(produto);
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public Filial getFilial() {
        return id.getFilial();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public void setFilial(Filial filial) {
        id.setFilial(filial);
    }

    public void atualizarEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque += quantidadeEstoque;
    }

}
