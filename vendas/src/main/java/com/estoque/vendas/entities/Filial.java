package com.estoque.vendas.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_filial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filial {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long codFilial;
    private String cnpj;
    private String nome;
    private String fantasia;
    private String logradouro;
    private String numero;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;
    private String email;
    private String telefone;
}
