package com.estoque.vendas.service;

import com.estoque.vendas.dto.AttDadosBancariosDTO;
import com.estoque.vendas.dto.DadosBancariosDTO;
import com.estoque.vendas.entities.DadosBancarios;
import com.estoque.vendas.repository.DadosBancariosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DadosBancariosService {

    @Autowired
    DadosBancariosRepository repository;

    @Transactional
    public DadosBancariosDTO cadastrarDadosBancarios(DadosBancariosDTO dto) {
        DadosBancarios dadosBancarios = new DadosBancarios();
        BeanUtils.copyProperties(dto, dadosBancarios);
        dadosBancarios = repository.save(dadosBancarios);
        return new DadosBancariosDTO(dadosBancarios);
    }

    @Transactional
    public DadosBancariosDTO consultarDadosBancarios(Long codDadosBancarios) {
        DadosBancarios dadosBancarios = repository.findById(codDadosBancarios).get();
        return new DadosBancariosDTO(dadosBancarios);
    }

    @Transactional
    public DadosBancariosDTO atualizarDadosBancarios(Long codDadosBancarios, AttDadosBancariosDTO dto) {
        DadosBancarios dadosBancarios = repository.findById(codDadosBancarios).get();
        BeanUtils.copyProperties(dto, dadosBancarios);
        dadosBancarios.setCodDadosBancarios(codDadosBancarios);
        dadosBancarios = repository.save(dadosBancarios);
        return new DadosBancariosDTO(dadosBancarios);
    }

    @Transactional
    public DadosBancariosDTO findById(Long codDadosBancarios) {
        DadosBancarios dadosBancarios = repository.findById(codDadosBancarios).get();
        return new DadosBancariosDTO(dadosBancarios);
    }
}
