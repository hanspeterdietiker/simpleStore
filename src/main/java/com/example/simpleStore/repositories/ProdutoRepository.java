package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.simpleStore.entities.ProdutoModel;

import java.util.Collection;
import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
    
    Optional<ProdutoModel> findById(long id);


}
