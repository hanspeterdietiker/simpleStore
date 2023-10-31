package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entities.produtoModel;


public interface ProdutoRepository extends JpaRepository<produtoModel, Long>{

}
