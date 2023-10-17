package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entity.compraModel;
import java.util.List;


public interface CompraRepository extends JpaRepository<compraModel, Long> {
    compraModel findByQuantidade(int quantidade);
}
