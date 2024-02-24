package com.estoque.vendas.service;

import com.estoque.vendas.Util.ConsumoApiCep;
import com.estoque.vendas.dto.EnderecoDTO;
import com.estoque.vendas.entities.Endereco;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.repository.EnderecoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private ConsumoApiCep consultarCepApi;

    @Transactional
    public EnderecoDTO cadastrarEndereco(String cep,String numero) throws RuntimeException {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        if (repository.findByCep(cep) == null) {
            enderecoDTO = consultarCepApi.consultarCep(cep);
            Endereco newEndereco = new Endereco();
            BeanUtils.copyProperties(enderecoDTO, newEndereco);
            newEndereco.setNumero(numero);
            repository.save(newEndereco);
        }
        return enderecoDTO;
    }
}
