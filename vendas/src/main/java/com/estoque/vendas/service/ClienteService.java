package com.estoque.vendas.service;

import com.estoque.vendas.dto.ClienteDTO;
import com.estoque.vendas.dto.EnderecoDTO;
import com.estoque.vendas.dto.RegisterClienteDTO;
import com.estoque.vendas.entities.Cliente;
import com.estoque.vendas.entities.Endereco;
import com.estoque.vendas.enums.StatusCliente;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    EnderecoService enderecoService;


    @Transactional
    public ClienteDTO findById(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow();
        return new ClienteDTO(cliente);
    }

    @Transactional
    public ClienteDTO findByCpf(String cpf) {
        Cliente cliente = repository.findByCpf(cpf);
        return new ClienteDTO(cliente);
    }

    @Transactional
    public ClienteDTO insert(RegisterClienteDTO dto) throws RuntimeException {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente);
        cliente.setStatus(StatusCliente.ATIVO);

        EnderecoDTO enderecoDTO = enderecoService.cadastrarEndereco(dto.getCep(),dto.getNumero());

        cliente.setEndereco(new Endereco(enderecoDTO));

        cliente = repository.save(cliente);

        return new ClienteDTO(cliente);
    }

    @Transactional
    public ClienteDTO update(Long id, RegisterClienteDTO dto) {
        Cliente cliente = repository.findById(id).orElseThrow();
        BeanUtils.copyProperties(dto, cliente);
        cliente = repository.save(cliente);
        return new ClienteDTO(cliente);
    }
}
