package com.estoque.vendas.dto;

import com.estoque.vendas.entities.EstoqueFilial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstoqueFilialDTO {

    private Long codProduto;
    private Long codFilial;
    private Integer quantidadeEstoque;

    public EstoqueFilialDTO(EstoqueFilial entity) {
        codProduto = entity.getProduto().getCodProduto();
        codFilial = entity.getFilial().getCodFilial();
        quantidadeEstoque = entity.getQuantidadeEstoque();
    }
}
