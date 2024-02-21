package com.estoque.vendas.entities;

import com.estoque.vendas.enums.StatusCliente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCliente;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private StatusCliente status;
}