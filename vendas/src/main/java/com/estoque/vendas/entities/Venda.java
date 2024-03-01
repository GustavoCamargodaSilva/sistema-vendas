package com.estoque.vendas.entities;

import com.estoque.vendas.enums.FormaPagamento;
import com.estoque.vendas.enums.StatusVenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "venda")
@Table(name = "tb_vendas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVenda;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataVenda;
    private StatusVenda statusVenda;
    private FormaPagamento formaPagamento;
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cod_vendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.venda")
    private Set<VendaItem> vendaItems = new HashSet<>();

    public List<Produto> getProdutos() {
        return vendaItems.stream().map(x -> x.getProduto()).toList();
    }
}
