package com.estoque.vendas.dto;

import com.estoque.vendas.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO {

    private Long codCategoria;
    private String nome;

    public CategoriaDTO(Categoria entity) {
        codCategoria = entity.getCodCategoria();
        nome = entity.getNome();
    }
}
