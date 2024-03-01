package com.estoque.vendas.controller;

import com.estoque.vendas.dto.*;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.repository.VendedorRepository;
import com.estoque.vendas.service.DadosBancariosService;
import com.estoque.vendas.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @Autowired
    private DadosBancariosService dadosBancariosService;


    @GetMapping("/listar")
    public ResponseEntity<List<VendedorDTO>> consultarVendedores(){
       List<VendedorDTO> list = service.consultarVendedor();
       return ResponseEntity.ok().body(list);
    }

    @GetMapping("/listarcodigo/{codvendedor}")
    public ResponseEntity<VendedorDTO> consultarVendedorId(@PathVariable Long codvendedor){
       VendedorDTO dto = service.consultarVendedorCodvendedor(codvendedor);
       return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastroVendedorDTO> cadastrarVendedor(@RequestBody CadastroVendedorDTO entityDTO) throws RuntimeException {
        VendedorDTO dto = service.insert(entityDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizarsenha")
    public ResponseEntity<VendedorDTO> atualizarSenha(@RequestBody AtualizarSenhaDTO dto){
        VendedorDTO att = service.atualizarSenha(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizardados")
    public ResponseEntity<VendedorDTO> atualizarDados(@RequestBody AttDadosVendedor dto) throws RuntimeException {
        VendedorDTO att = service.alterarDadosVendedor(dto);
        return ResponseEntity.ok().build();
    }
}
