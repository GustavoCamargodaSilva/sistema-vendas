package com.estoque.vendas.repository;

import com.estoque.vendas.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

}
