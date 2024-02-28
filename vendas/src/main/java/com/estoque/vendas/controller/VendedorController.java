package com.estoque.vendas.controller;

import com.estoque.vendas.dto.CadastroVendedorDTO;
import com.estoque.vendas.dto.VendedorDTO;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.repository.VendedorRepository;
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


    @GetMapping("/listar")
    public ResponseEntity<List<VendedorDTO>> consultarVendedor(){
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


}
