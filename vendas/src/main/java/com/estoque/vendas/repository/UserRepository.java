package com.estoque.vendas.repository;

import com.estoque.vendas.entities.User;
import com.estoque.vendas.projections.VendedorDatailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByNome(String nome);

    @Query(nativeQuery = true, value = "SELECT tb_user.email AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority" +
            " FROM tb_user" +
            " INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id" +
            " INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id" +
            " WHERE tb_user.email = :email")
    List<VendedorDatailsProjection> searchVendedorAndRolesByEmail(String email);
}
