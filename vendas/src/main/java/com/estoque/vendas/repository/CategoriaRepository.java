package com.estoque.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.vendas.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findBycodCategoria(Long codCategoria);

    Categoria findByNome(String nome);

}
