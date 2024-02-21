package com.estoque.vendas.entities;

import com.estoque.vendas.enums.StatusVenda;
import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVenda;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataVenda;
    private StatusVenda statusVenda;

    @OneToOne
    @MapsId
    private Pagamento pagamento;


}
