package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entities.ClienteModel;



import java.util.Optional;


public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findById(Long id);
    ClienteModel findByNameClient(String nameClient);



}
