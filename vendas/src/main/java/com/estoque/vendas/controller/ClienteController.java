package com.estoque.vendas.controller;

import com.estoque.vendas.dto.ClienteDTO;
import com.estoque.vendas.dto.RegisterClienteDTO;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.repository.ClienteRepository;
import com.estoque.vendas.service.ClienteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {


    @Autowired
    private ClienteService service;

    @GetMapping(value = "/consultarid/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        ClienteDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/consultarcpf/{cpf}")
    public ResponseEntity<ClienteDTO> findByCpf(@PathVariable String cpf){
        ClienteDTO dto = service.findByCpf(cpf);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody RegisterClienteDTO dto) throws RuntimeException {
        ClienteDTO clienteDTO = service.insert(dto);
        return ResponseEntity.ok(clienteDTO);
    }
}
