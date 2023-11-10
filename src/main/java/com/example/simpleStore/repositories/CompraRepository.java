package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entities.CompraModel;

import java.util.Collection;
import java.util.Optional;


public interface CompraRepository extends JpaRepository<CompraModel, Long> {

    Optional<CompraModel> findById(long id);
}
