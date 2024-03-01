package com.estoque.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttDadosBancariosDTO {

    private String codDadosBancarios;
    private String agencia;
    private String conta;
    private String banco;
    private String tipoConta;
    private String pix;
}
