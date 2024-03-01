package com.estoque.vendas.service;

import com.estoque.vendas.dto.VendaDTO;
import com.estoque.vendas.entities.Venda;
import com.estoque.vendas.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendasService {

    @Autowired
    private VendasRepository repository;

    @Transactional
    public List<VendaDTO> listarVendas() {
        List<Venda> list = repository.findAll();
        return list.stream().map(VendaDTO::new).toList();
    }
}
