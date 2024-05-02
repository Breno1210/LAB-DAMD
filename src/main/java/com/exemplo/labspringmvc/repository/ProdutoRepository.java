package com.exemplo.labspringmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.labspringmvc.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
