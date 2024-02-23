package com.estoque.vendas.repository;

import com.estoque.vendas.entities.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialRepository extends JpaRepository<Filial, Long> {
}
