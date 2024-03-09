package com.estoque.vendas.dto;

import com.estoque.vendas.entities.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO {

    private Long codVendedor;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String telefone;
    private Double salarioBase;
    private EnderecoDTO endereco;
    private DadosBancariosDTO dadosBancarios;

    public VendedorDTO(Vendedor entity) {
        codVendedor = entity.getCodVendedor();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        email = entity.getEmail();
        senha = entity.getSenha();
        telefone = entity.getTelefone();
        salarioBase = entity.getSalarioBase();
        endereco = new EnderecoDTO(entity.getEndereco());
        dadosBancarios = new DadosBancariosDTO(entity.getDadosBancarios());
    }
}
