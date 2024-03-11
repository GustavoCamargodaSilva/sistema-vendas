package com.estoque.vendas.controller;

import com.estoque.vendas.dto.*;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.service.DadosBancariosService;
import com.estoque.vendas.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorController {

    @Autowired
    private User service;

    @Autowired
    private DadosBancariosService dadosBancariosService;


    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> consultarVendedores(){
       List<UserDTO> list = service.consultarVendedor();
       return ResponseEntity.ok().body(list);
    }

    @GetMapping("/listarcodigo/{codvendedor}")
    public ResponseEntity<UserDTO> consultarVendedorId(@PathVariable Long codvendedor){
       UserDTO dto = service.consultarVendedorCodvendedor(codvendedor);
       return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastroVendedorDTO> cadastrarVendedor(@RequestBody CadastroVendedorDTO entityDTO) throws RuntimeException {
        UserDTO dto = service.insert(entityDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizarsenha")
    public ResponseEntity<UserDTO> atualizarSenha(@RequestBody AtualizarSenhaDTO dto){
        UserDTO att = service.atualizarSenha(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizardados")
    public ResponseEntity<UserDTO> atualizarDados(@RequestBody AttDadosVendedor dto) throws RuntimeException {
        UserDTO att = service.alterarDadosVendedor(dto);
        return ResponseEntity.ok().build();
    }
}
