package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entities.compraModel;


public interface CompraRepository extends JpaRepository<compraModel, Long> {
    
}
