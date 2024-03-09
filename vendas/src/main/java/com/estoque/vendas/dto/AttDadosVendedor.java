package com.estoque.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttDadosVendedor {

    private Long codVendedor;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String cep;
    private String numero;
    private DadosBancariosDTO dadosBancarios;
}
