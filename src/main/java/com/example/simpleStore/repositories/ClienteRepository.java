package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entity.clienteModel;

public interface ClienteRepository extends JpaRepository<clienteModel, Long>{
    clienteModel findByName(String name);
    clienteModel findByEmail (String email);
}
