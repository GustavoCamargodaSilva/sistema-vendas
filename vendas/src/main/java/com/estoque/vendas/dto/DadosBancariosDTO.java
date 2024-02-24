package com.estoque.vendas.dto;

import com.estoque.vendas.entities.DadosBancarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosBancariosDTO {

    private Long codDadosBancarios;
    private String agencia;
    private String conta;
    private String banco;
    private String tipoConta;
    private String pix;

    public DadosBancariosDTO(DadosBancarios entity) {
        this.codDadosBancarios = entity.getCodDadosBancarios();
        this.agencia = entity.getAgencia();
        this.conta = entity.getConta();
        this.banco = entity.getBanco();
        this.tipoConta = entity.getTipoConta();
        this.pix = entity.getPix();
    }
}
