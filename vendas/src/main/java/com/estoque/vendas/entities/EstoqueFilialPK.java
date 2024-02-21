package com.estoque.vendas.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueFilialPK {

    @ManyToOne
    @JoinColumn(name = "cod_filial")
    private Filial filial;

    @ManyToOne
    @JoinColumn(name = "cod_produto")
    private Produto produto;

}
