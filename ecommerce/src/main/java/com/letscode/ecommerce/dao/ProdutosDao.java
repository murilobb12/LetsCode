    package com.letscode.ecommerce.dao;

import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutosDao extends JpaRepository<Produtos, Long> {

    //Named Methods
    Produtos findAllById(long id);
//
//    //Jpa Native Query
//    @Query(value = "SELECT * FROM Produtos WHERE id = userId", nativeQuery = true)
//    Produtos findByProductId(long userId);

    //JPQL
//    @Query("SELECT * FROM Produtos WHERE id = :id")
//    Produtos findProductByID(@Param("id") long id);




}
