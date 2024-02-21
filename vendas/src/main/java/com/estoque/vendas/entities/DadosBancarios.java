package com.estoque.vendas.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DadosBancarios {

    private Long id;
    private String agencia;
    private String conta;
    private String banco;
    private String tipoConta;
    private String pix;

}
