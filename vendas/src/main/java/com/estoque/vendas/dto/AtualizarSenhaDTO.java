package com.estoque.vendas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarSenhaDTO {

    private Long codVendedor;
    private String senha;

    public AtualizarSenhaDTO(VendedorDTO dto){
        this.codVendedor = dto.getCodVendedor();
        this.senha = dto.getSenha();

    }

}
