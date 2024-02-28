package com.estoque.vendas.dto;

import com.estoque.vendas.entities.DadosBancarios;
import com.estoque.vendas.entities.Endereco;
import com.estoque.vendas.entities.Venda;
import com.estoque.vendas.entities.Vendedor;
import com.estoque.vendas.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String telefone;
    private UserRole role;
    private Double salarioBase;
    private EnderecoDTO endereco;
    private DadosBancariosDTO dadosBancarios;

    public VendedorDTO(Vendedor entity) {
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        email = entity.getEmail();
        senha = entity.getSenha();
        telefone = entity.getTelefone();
        role = entity.getRole();
        salarioBase = entity.getSalarioBase();
        endereco = new EnderecoDTO(entity.getEndereco());
        dadosBancarios = new DadosBancariosDTO(entity.getDadosBancarios());
    }
}
