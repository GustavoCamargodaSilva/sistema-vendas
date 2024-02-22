package com.estoque.vendas.controller;

import com.estoque.vendas.dto.ProdutoDTO;
import com.estoque.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/listarprodutos")
    public ResponseEntity<Page<ProdutoDTO>> findAllPaged(Pageable pageable){
        Page<ProdutoDTO> list = service.findAllPage(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/listarprodutos/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        ProdutoDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/cadastrarproduto")
    public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getCodProduto()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
