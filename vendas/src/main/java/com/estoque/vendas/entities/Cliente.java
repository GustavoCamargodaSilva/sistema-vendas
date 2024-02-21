package com.estoque.vendas.entities;

import com.estoque.vendas.enums.StatusCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "cliente")
    private Set<Venda> vendas = new HashSet<>();


    @OneToOne
    @MapsId
    private Endereco endereco;
}
