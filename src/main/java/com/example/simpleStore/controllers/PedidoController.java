package com.example.simpleStore.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.simpleStore.services.PedidoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.entities.PedidoModel;


@RestController
@RequestMapping("/api/v1/orders")
public class PedidoController {


    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping("/registering-order")
    public ResponseEntity<PedidoModel> create(@RequestBody @Valid PedidoModel produto, HttpServletRequest request) {
        BigDecimal valorTotalCompra = produto.valorTotalCompra();
        var newProduto = new PedidoModel(produto.getId(), produto.getNameProduct(),
                produto.getPrice(), produto.getQuantidade());
        newProduto.setValorTotalCompra(valorTotalCompra);
        produto.setValorTotalCompra(valorTotalCompra);

        pedidoService.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
    }


    @GetMapping("/searching-by-order/{id}")
    public ResponseEntity<Optional<PedidoModel>> getById(@PathVariable Long id, HttpServletRequest request) throws Exception {
        var produto = pedidoService.getById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/searching-by-orders")
    public List<PedidoModel> getAllProdutos(HttpServletRequest request) throws Exception {
        return pedidoService.getAllProdutos();
    }

    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<String> deleteUserEntity(@PathVariable Long id, HttpServletRequest request) throws Exception {
        pedidoService.deleteProduct(id);
        return ResponseEntity.ok().body("Produto Deletado");
    }
}

