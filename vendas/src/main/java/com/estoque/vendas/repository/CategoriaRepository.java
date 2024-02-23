package com.estoque.vendas.repository;

import com.estoque.vendas.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findBycodCategoria(Long codCategoria);

    Categoria findByNome(String nome);

}
