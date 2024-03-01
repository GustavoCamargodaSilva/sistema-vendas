package com.estoque.vendas.repository;

import com.estoque.vendas.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Venda, Long> {

}
