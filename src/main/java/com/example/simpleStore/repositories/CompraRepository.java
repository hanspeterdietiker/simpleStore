package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entities.CompraModel;


public interface CompraRepository extends JpaRepository<CompraModel, Long> {
    
}
