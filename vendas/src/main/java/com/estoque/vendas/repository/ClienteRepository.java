package com.estoque.vendas.repository;

import com.estoque.vendas.dto.ClienteDTO;
import com.estoque.vendas.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

}
