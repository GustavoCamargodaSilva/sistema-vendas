package com.estoque.vendas.dto;

import com.estoque.vendas.entities.EstoqueFilial;
import com.estoque.vendas.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

    private Long codProduto;
    private String nome;
    private String marca;
    private String imgUrl;
    private Double preco;
    private String descricao;
    private String tamanho;

    private CategoriaDTO categoria;


    public ProdutoDTO(Produto entity){
        codProduto = entity.getCodProduto();
        nome = entity.getNome();
        marca = entity.getMarca();
        imgUrl = entity.getImgUrl();
        preco = entity.getPreco();
        descricao = entity.getDescricao();
        tamanho = entity.getTamanho();
        categoria = new CategoriaDTO(entity.getCategoria());
    }


}
