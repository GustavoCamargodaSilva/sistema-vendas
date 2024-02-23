package com.estoque.vendas.service;

import com.estoque.vendas.dto.CategoriaDTO;
import com.estoque.vendas.entities.Categoria;
import com.estoque.vendas.exceptions.DataIntegrityViolationException;
import com.estoque.vendas.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
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

    @Transactional
    public CategoriaDTO findByCodCategoria(Long codCategoria) {
        Categoria cat = repository.findById(codCategoria).get();
        return new CategoriaDTO(cat);
    }

    @Transactional
    public CategoriaDTO insert(CategoriaDTO dto) {
        Categoria cat = new Categoria();
        BeanUtils.copyProperties(dto, cat);
        cat = repository.save(cat);
        return new CategoriaDTO(cat);
    }

    @Transactional
    public void delete(Long codCategoria) {
            repository.deleteById(codCategoria);
    }

    public CategoriaDTO update(CategoriaDTO dto) {
        Categoria cat = repository.findById(dto.getCodCategoria()).get();
        BeanUtils.copyProperties(dto, cat);
        cat = repository.save(cat);
        return new CategoriaDTO(cat);
    }
}
