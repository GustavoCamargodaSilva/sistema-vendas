package com.estoque.vendas.entities;

import jakarta.persistence.*;
import lombok.*;

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
}
