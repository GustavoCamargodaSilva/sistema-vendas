package com.estoque.vendas.controller;

import com.estoque.vendas.repository.FilialRepository;
import com.estoque.vendas.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/filiais")
public class FilialController {

    @Autowired
    private FilialService service;

    @Autowired
    private FilialRepository repository;






}
