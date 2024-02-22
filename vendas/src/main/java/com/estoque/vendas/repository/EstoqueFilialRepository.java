package com.estoque.vendas.repository;

import com.estoque.vendas.entities.EstoqueFilial;
import com.estoque.vendas.entities.EstoqueFilialPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  EstoqueFilialRepository extends JpaRepository<EstoqueFilial, EstoqueFilialRepository> {

    @Query("SELECT ef FROM EstoqueFilial ef WHERE ef.id.produto.codProduto = :codProduto AND ef.id.filial.codFilial = :codFilial")
    EstoqueFilial findByCodProdutoAndCodFilial(Long codProduto, Long codFilial);
}
