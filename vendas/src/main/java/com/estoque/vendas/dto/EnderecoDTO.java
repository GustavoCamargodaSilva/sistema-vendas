package com.estoque.vendas.dto;

import com.estoque.vendas.entities.Endereco;
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

    public EnderecoDTO(Endereco entity) {
        codEndereco = entity.getCodEndereco();
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        complemento = entity.getComplemento();
        bairro = entity.getBairro();
        localidade = entity.getLocalidade();
        uf = entity.getUf();
        ibge = entity.getIbge();
        gia = entity.getGia();
        ddd = entity.getDdd();
        siafi = entity.getSiafi();
        numero = entity.getNumero();
    }


}
