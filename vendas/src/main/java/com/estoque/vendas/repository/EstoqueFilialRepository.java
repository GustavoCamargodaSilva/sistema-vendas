package com.estoque.vendas.repository;

import com.estoque.vendas.entities.EstoqueFilial;
import com.estoque.vendas.entities.EstoqueFilialPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EstoqueFilialRepository extends JpaRepository<EstoqueFilial, Long> {

}
