package com.estoque.vendas.enums;

public enum StatusCliente {

        ATIVO("Ativo"),
        INATIVO("Inativo");

        private String status;

        StatusCliente(String status){
            this.status = status;
        }
}
