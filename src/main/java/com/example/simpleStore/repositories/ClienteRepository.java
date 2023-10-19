package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entity.clienteModel;

public interface ClienteRepository extends JpaRepository<clienteModel, Long> {
    clienteModel findByNameClient(String nameClient);

    clienteModel findByEmail(String email);
}
