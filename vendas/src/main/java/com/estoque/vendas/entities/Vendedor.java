package com.estoque.vendas.entities;

import com.estoque.vendas.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_vendedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVendedor;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String telefone;
    private UserRole role;
    private Double salarioBase;

    @OneToOne
    @MapsId
    private Endereco endereco;

    @OneToOne
    @MapsId
    private DadosBancarios dadosBancarios;

}
