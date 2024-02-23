package com.estoque.vendas.controller;

import com.estoque.vendas.dto.CategoriaDTO;
import com.estoque.vendas.repository.CategoriaRepository;
import com.estoque.vendas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<CategoriaDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{codCategoria}")
    public ResponseEntity<CategoriaDTO> findByCodCategoria(@PathVariable Long codCategoria){
        CategoriaDTO dto = service.findByCodCategoria(codCategoria);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO dto){
        dto = service.update(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO dto){
        if(this.repository.findByNome(dto.getNome()) != null){
            return ResponseEntity.badRequest().build();
        }
        dto = service.insert(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{codCategoria}")
    public ResponseEntity<Void> delete(@PathVariable Long codCategoria){
        service.delete(codCategoria);
        return ResponseEntity.noContent().build();
    }
}
