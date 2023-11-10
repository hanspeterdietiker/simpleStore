package com.example.simpleStore.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.entities.CompraModel;
import com.example.simpleStore.repositories.CompraRepository;

@RestController
@RequestMapping("/api/v1/compras")
public class CompraController {

    private final CompraRepository compraRepository;

    public CompraController(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @PostMapping("/register-orders")
    public ResponseEntity<CompraModel> create(@RequestBody CompraModel buy) {
        if (buy != null) {
            CompraModel novaCompra = compraRepository.save(buy);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(novaCompra);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/searching-by-orders")
    public List<CompraModel> getAllCompras() {
        return compraRepository.findAll();
    }
}
