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

    private Long id;
    private String senha;

    public AtualizarSenhaDTO(UserDTO dto){
        this.id = dto.getId();
        this.senha = dto.getPassword();

    }

}
