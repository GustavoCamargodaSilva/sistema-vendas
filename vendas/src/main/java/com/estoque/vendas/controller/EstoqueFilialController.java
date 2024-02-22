package com.estoque.vendas.controller;

import com.estoque.vendas.dto.EstoqueFilialDTO;
import com.estoque.vendas.repository.EstoqueFilialRepository;
import com.estoque.vendas.service.EstoqueFilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estoquefilial")
public class EstoqueFilialController {

    @Autowired
    private EstoqueFilialService service;

    @Autowired
    private EstoqueFilialRepository repository;

    @GetMapping(value = "/{codProduto}/{codFilial}")
    public ResponseEntity<EstoqueFilialDTO> findByCodProdutoAndCodFilial(@PathVariable Long codProduto, @PathVariable Long codFilial){
        EstoqueFilialDTO dto = service.findByCodProdutoAndCodFilial(codProduto, codFilial);
        return ResponseEntity.ok().body(dto);
    }
}
