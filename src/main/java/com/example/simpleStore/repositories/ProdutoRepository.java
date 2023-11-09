package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.simpleStore.entities.produtoModel;
import java.util.List;



public interface ProdutoRepository extends JpaRepository<produtoModel, Long>{
    
    List<produtoModel> findById(long id);
}
