package com.estoque.vendas.repository;

import com.estoque.vendas.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    Vendedor findByNome(String nome);
}
