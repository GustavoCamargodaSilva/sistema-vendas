package com.estoque.vendas.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnderecoDTO {

    private Long codEndereco;
    private String cep;
    @Column(columnDefinition = "TEXT")
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private String numero;

    public EnderecoDTO(RegisterCepDTO entity) {
        cep = entity.getCep();
        numero = entity.getNumero();
    }


}
