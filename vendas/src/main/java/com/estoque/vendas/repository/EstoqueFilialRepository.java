package com.estoque.vendas.repository;

import com.estoque.vendas.entities.EstoqueFilial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  EstoqueFilialRepository extends JpaRepository<EstoqueFilial, EstoqueFilialRepository> {

    @Query("SELECT ef FROM EstoqueFilial ef WHERE ef.id.produto.codProduto = :codProduto AND ef.id.filial.codFilial = :codFilial")
    EstoqueFilial findByCodProdutoAndCodFilial(Long codProduto, Long codFilial);

    @Query("SELECT ef FROM EstoqueFilial ef WHERE ef.id.produto.codProduto = :codigoProduto")
    List<EstoqueFilial> findByCodigoProduto(@Param("codigoProduto") Long codigoProduto);
}
