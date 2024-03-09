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
public class CadastroVendedorDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String cep;
    private String numero;
    private DadosBancariosDTO dadosBancarios;

    public CadastroVendedorDTO(VendedorDTO entity) {
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        cep = entity.getEndereco().getCep();
        numero = entity.getEndereco().getNumero();
        dadosBancarios = entity.getDadosBancarios();
    }

}
