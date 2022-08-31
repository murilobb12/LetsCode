package com.letscode.ecommerce.dao;

import com.letscode.ecommerce.models.Cliente;
import com.letscode.ecommerce.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosDao extends JpaRepository<Produtos, Long> {

    Produtos findAllById(long id);

}
