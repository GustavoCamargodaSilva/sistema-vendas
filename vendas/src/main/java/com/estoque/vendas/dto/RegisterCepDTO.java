package com.estoque.vendas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterCepDTO {

    @NotNull
    @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    String cep;
    @NotNull
    String numero;
}
