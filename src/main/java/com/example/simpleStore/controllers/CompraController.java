package com.example.simpleStore.controllers;

import java.util.List;
import java.util.Optional;


import com.example.simpleStore.entities.ClienteModel;
import com.example.simpleStore.entities.ProdutoModel;
import com.example.simpleStore.services.CompraService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.simpleStore.entities.CompraModel;

@RestController
@RequestMapping("/api/v1/compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }


    @PostMapping("/register-order")
    public ResponseEntity<CompraModel> createCompra(@RequestBody CompraModel buy, HttpServletRequest request) {
       /* var nameClient = request.getAttribute("nameClient");
        buy.setCliente((ClienteModel) nameClient);

        var nameProduct = request.getAttribute("nameProduto");
        buy.setProduto((ProdutoModel) nameProduct);

        var priceProduto = request.getAttribute("valorPorduto");
        buy.setPrice((ProdutoModel) priceProduto);*/

        var newCompra = new CompraModel(
                buy.getId(),
                 buy.getPurchasedAt());
        compraService.createCompra(buy);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCompra);
    }


    @GetMapping("/searching-by-order/{id}")
    public ResponseEntity<Optional<CompraModel>> getById(@PathVariable Long id) throws Exception {
        var compra = compraService.getById(id);
        return ResponseEntity.ok().body(compra);
    }

    @GetMapping("/searching-by-orders")
    public List<CompraModel> getAllCompras() throws Exception {
        return compraService.gettAllCompras();
    }
}
