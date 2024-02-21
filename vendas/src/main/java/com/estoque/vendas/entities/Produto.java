package com.estoque.vendas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "produto")
@Table(name = "tb_produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;
    private String nome;
    private String marca;
    private String imgUrl;
    private Double preco;
    private String descricao;
    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "cod_categoria")
    private Categoria categoria;


    @OneToMany(mappedBy = "id.produto")
    private Set<EstoqueFilial> estoqueFiliais = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<VendaItem> vendaItems = new HashSet<>();

    public List<Filial> getFilial() {
        return estoqueFiliais.stream().map(x -> x.getFilial()).toList();
    }

    public List<Venda> getVendas() {
        return vendaItems.stream().map(x -> x.getVenda()).toList();
    }
}
