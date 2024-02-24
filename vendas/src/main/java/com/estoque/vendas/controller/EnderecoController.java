package com.estoque.vendas.controller;

import com.amazonaws.Response;
import com.estoque.vendas.dto.EnderecoDTO;
import com.estoque.vendas.dto.RegisterCepDTO;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.repository.EnderecoRepository;
import com.estoque.vendas.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @Autowired
    private EnderecoRepository repository;

    @PostMapping("/cadastrar/")
    public ResponseEntity<RegisterCepDTO> cadastrarEndereco(@RequestBody @Valid RegisterCepDTO dto) throws RuntimeException {
        EnderecoDTO endereco = service.cadastrarEndereco(dto.getCep(),dto.getNumero());
        return ResponseEntity.ok().build();
    }
}
