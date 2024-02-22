package com.estoque.vendas.service;

import com.estoque.vendas.dto.CategoriaDTO;
import com.estoque.vendas.entities.Categoria;
import com.estoque.vendas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional
    public List<CategoriaDTO> findAll() {
        List<Categoria> categorias = repository.findAll();
        return categorias.stream().map(x -> new CategoriaDTO(x)).toList();
    }
}
