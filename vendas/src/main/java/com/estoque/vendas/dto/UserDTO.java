package com.estoque.vendas.dto;

import com.estoque.vendas.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String password;
    private String telefone;
    private Double salarioBase;
    private EnderecoDTO endereco;
    private DadosBancariosDTO dadosBancarios;

    public UserDTO(User entity) {
        id = entity.getId();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        salarioBase = entity.getSalarioBase();
        endereco = new EnderecoDTO(entity.getEndereco());
        dadosBancarios = new DadosBancariosDTO(entity.getDadosBancarios());
    }
}
