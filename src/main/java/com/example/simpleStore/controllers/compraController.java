package com.example.simpleStore.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/registering-orders")
    public ResponseEntity<compraModel> create(@RequestBody compraModel buy) {
        if (buy != null) {
            compraModel novaCompra = compraRepository.save(buy);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(novaCompra);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity updateCompra(@PathVariable Long id, @RequestBody compraModel CompraModel) {

        var compra = this.compraRepository.findById(id).orElse(null);

        if (compra == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A ID da compra não encontrada");

        }

        var compraUpdate = this.compraRepository.save(compra);
        return ResponseEntity.ok().body(compraUpdate);

    }

    @GetMapping("/search-by-orders")
    public List<compraModel> getAllCompras() {
        return compraRepository.findAll();
    }
}
