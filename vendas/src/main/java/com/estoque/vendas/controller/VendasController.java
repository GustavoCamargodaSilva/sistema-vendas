package com.estoque.vendas.controller;

import com.estoque.vendas.dto.VendaDTO;
import com.estoque.vendas.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendasService service;

    @GetMapping("/listarvendas")
    public ResponseEntity<List<VendaDTO>> listarVendas(){
        List<VendaDTO> list = service.listarVendas();
        return ResponseEntity.ok(list);
    }

}
