package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.simpleStore.entities.PedidoModel;

import java.util.Optional;


public interface PedidoRepository extends JpaRepository<PedidoModel, Long>{
    
    Optional<PedidoModel> findById(Long id);


}
