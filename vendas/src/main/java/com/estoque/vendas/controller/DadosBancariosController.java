package com.estoque.vendas.controller;

import com.estoque.vendas.dto.AttDadosBancariosDTO;
import com.estoque.vendas.dto.DadosBancariosDTO;
import com.estoque.vendas.service.DadosBancariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dadosbancarios")
public class DadosBancariosController {

    @Autowired
    private DadosBancariosService service;

    @GetMapping(value = "/{codDadosBancarios}")
    public ResponseEntity<DadosBancariosDTO> consultarDadosBancarios(@PathVariable Long codDadosBancarios){
        DadosBancariosDTO dto = service.consultarDadosBancarios(codDadosBancarios);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/{codDadosBancarios}")
    public ResponseEntity<DadosBancariosDTO> atualizarDadosBancarios(@PathVariable Long codDadosBancarios, @RequestBody AttDadosBancariosDTO dto){
        DadosBancariosDTO dadosBancariosDTO = service.atualizarDadosBancarios(codDadosBancarios, dto);
        return ResponseEntity.ok(dadosBancariosDTO);
    }

    @PostMapping
    public ResponseEntity<DadosBancariosDTO> cadastrarDadosBancarios(@RequestBody DadosBancariosDTO dto){
        DadosBancariosDTO dadosBancariosDTO = service.cadastrarDadosBancarios(dto);
        return ResponseEntity.ok(dadosBancariosDTO);
    }

}
