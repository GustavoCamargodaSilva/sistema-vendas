package com.estoque.vendas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_dados_bancarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DadosBancarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codDadosBancarios;
    private String agencia;
    private String conta;
    private String banco;
    private String tipoConta;
    private String pix;

    @OneToOne(mappedBy = "dadosBancarios", cascade = CascadeType.ALL)
    private Vendedor vendedor;

}
