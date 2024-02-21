package com.estoque.vendas.enums;

public enum FormaPagamento {

    DEBITO("debito"),
    CREDITO("credito"),
    DINHEIRO("dinheiro"),
    PIX("pix");

    private String formaPagamento;

    FormaPagamento(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }
}
