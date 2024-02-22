package com.estoque.vendas.service;

import com.estoque.vendas.dto.EstoqueFilialDTO;
import com.estoque.vendas.entities.EstoqueFilial;
import com.estoque.vendas.repository.EstoqueFilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueFilialService {

    @Autowired
    private EstoqueFilialRepository repository;
    @Transactional
    public EstoqueFilialDTO findByCodProdutoAndCodFilial(Long codProduto, Long codFilial) {
        EstoqueFilial entity = repository.findByCodProdutoAndCodFilial(codProduto, codFilial);
        return new EstoqueFilialDTO(entity);
    }
}
