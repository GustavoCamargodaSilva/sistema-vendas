package com.estoque.vendas.entities;

import com.estoque.vendas.dto.DadosBancariosDTO;
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

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "dadosBancarios")
    private Vendedor vendedor;

    public DadosBancarios(DadosBancariosDTO dto){
        this.agencia = dto.getAgencia();
        this.conta = dto.getConta();
        this.banco = dto.getBanco();
        this.tipoConta = dto.getTipoConta();
        this.pix = dto.getPix();
    }
}
