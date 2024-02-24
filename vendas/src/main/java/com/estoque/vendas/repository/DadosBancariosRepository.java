package com.estoque.vendas.repository;

import com.estoque.vendas.entities.DadosBancarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, Long> {
}
