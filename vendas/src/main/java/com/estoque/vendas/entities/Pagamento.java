package com.estoque.vendas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_pagamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pagamento {

    private Long codPagamento;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataPagamento;
    private String formaPagamento;
}
