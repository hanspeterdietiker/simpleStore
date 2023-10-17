package com.example.simpleStore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.entity.compraModel;
import com.example.simpleStore.repositories.CompraRepository;

@RestController
@RequestMapping("/compras")
public class compraController {
    private final CompraRepository compraRepository;

    public compraController(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @GetMapping("/search-by-orders")
    public List<compraModel> getAllCompras(){
        return compraRepository.findAll();
    }
}
