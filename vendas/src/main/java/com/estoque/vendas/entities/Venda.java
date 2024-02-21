package com.estoque.vendas.entities;

import com.estoque.vendas.enums.StatusVenda;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity(name = "venda")
@Table(name = "tb_vendas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Venda {

    private Long codVenda;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataVenda;
    private StatusVenda statusVenda;
}
