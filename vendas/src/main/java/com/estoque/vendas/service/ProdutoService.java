package com.estoque.vendas.service;

import com.estoque.vendas.dto.CategoriaDTO;
import com.estoque.vendas.dto.EstoqueFilialDTO;
import com.estoque.vendas.dto.ProdutoDTO;
import com.estoque.vendas.entities.Categoria;
import com.estoque.vendas.entities.EstoqueFilial;
import com.estoque.vendas.entities.Filial;
import com.estoque.vendas.entities.Produto;
import com.estoque.vendas.repository.CategoriaRepository;
import com.estoque.vendas.repository.EstoqueFilialRepository;
import com.estoque.vendas.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EstoqueFilialRepository estoqueRepository;

    public ProdutoDTO insert(ProdutoDTO dto) {
        Produto entity = new Produto();
        BeanUtils.copyProperties(dto, entity);

        // Verifica se a categoria já existe no banco de dados
        Categoria categoria = categoriaRepository.findBycodCategoria(dto.getCategoria().getCodCategoria());

        // Se a categoria não existir, ela será criada
        if (categoria == null) {
            categoria = new Categoria();
            categoria.setCodCategoria(dto.getCategoria().getCodCategoria());
            categoria.setNome(dto.getCategoria().getNome());
            categoria = categoriaRepository.save(categoria);
        }

        entity.setCategoria(categoria);

        // Salva o produto no banco de dados
        entity = repository.save(entity);

        return new ProdutoDTO(entity);
    }
}
