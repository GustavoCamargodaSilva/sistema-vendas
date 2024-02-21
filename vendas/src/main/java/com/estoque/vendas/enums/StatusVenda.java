package com.estoque.vendas.enums;

public enum StatusVenda {

    AGUARDANDO_PAGAMENTO("aguardando pagamento"),
    PAGAMENTO_CONFIRMADO("pagamento confirmado"),
    CANCELADO("cancelado");

    private String status;

    StatusVenda(String status){
        this.status = status;
    }

}
