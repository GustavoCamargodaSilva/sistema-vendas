package com.estoque.vendas.repository;

import com.estoque.vendas.entities.Vendedor;
import com.estoque.vendas.projections.VendedorDatailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    Vendedor findByNome(String nome);

    @Query(nativeQuery = true, value = "SELECT tb_vendedor.email AS username, tb_vendedor.senha, tb_role.id AS roleId, tb_role.authority" +
            " FROM tb_vendedor" +
            " INNER JOIN tb_vendedor_role ON tb_vendedor.cod_vendedor = tb_vendedor_role.vendedor_id" +
            " INNER JOIN tb_role ON tb_role.id = tb_vendedor_role.role_id" +
            " WHERE tb_vendedor.email = :email")
    List<VendedorDatailsProjection> searchVendedorAndRolesByEmail(String email);
}
