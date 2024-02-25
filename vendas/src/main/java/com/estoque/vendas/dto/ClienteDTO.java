package com.estoque.vendas.dto;

import com.estoque.vendas.entities.Cliente;
import com.estoque.vendas.entities.Endereco;
import com.estoque.vendas.entities.Venda;
import com.estoque.vendas.enums.StatusCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    private Long codCliente;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private StatusCliente status;

    @JsonIgnore
    private Set<VendaDTO> vendas = new HashSet<>();

    private EnderecoDTO endereco;

    public ClienteDTO(Cliente entity){
        codCliente = entity.getCodCliente();
        cpf = entity.getCpf();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        status = entity.getStatus();
        endereco = new EnderecoDTO(entity.getEndereco());
        for (Venda venda : entity.getVendas()){
            vendas.add(new VendaDTO(venda));
        }
    }
}
