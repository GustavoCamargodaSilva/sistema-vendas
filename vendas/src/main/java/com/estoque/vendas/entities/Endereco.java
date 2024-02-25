package com.estoque.vendas.entities;

import com.estoque.vendas.dto.EnderecoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEndereco;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private String numero;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Vendedor vendedor;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Cliente cliente;

    public Endereco(EnderecoDTO entity){
        this.cep = entity.getCep();
        this.logradouro = entity.getLogradouro();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.localidade = entity.getLocalidade();
        this.uf = entity.getUf();
        this.ibge = entity.getIbge();
        this.gia = entity.getGia();
        this.ddd = entity.getDdd();
        this.siafi = entity.getSiafi();
        this.numero = entity.getNumero();
    }
}
