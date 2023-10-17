package com.example.simpleStore.Compra;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
