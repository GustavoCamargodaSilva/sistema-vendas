package com.estoque.vendas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "filial")
@Table(name = "tb_filial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codEndereco;
    private String cnpj;
    private String nome;
    private String fantasia;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String municipio;
    private String uf;
    private String email;
    private String telefone;

}
