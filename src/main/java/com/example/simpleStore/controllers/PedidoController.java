package com.example.simpleStore.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    public ResponseEntity createPedido(@RequestBody @Valid PedidoModel pedido, HttpServletRequest request) throws Exception {
        BigDecimal valorTotalCompra = pedido.valorTotalCompra();
        var compradoAt = LocalDateTime.now();


        PedidoModel newPedido = new PedidoModel(pedido.getId(), pedido.getNameProduct(),
                pedido.getPrice(), pedido.getQuantidade(),
                compradoAt, pedido.getCliente());

        newPedido.setValorTotalCompra(valorTotalCompra);
        pedido.setValorTotalCompra(valorTotalCompra);

        pedidoService.createPedido(newPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPedido);
    }


    @GetMapping("/searching-by-order/{id}")
    public ResponseEntity<Optional<PedidoModel>> getById(@PathVariable Long id, HttpServletRequest request) throws Exception {
        var produto = pedidoService.getById(id);
        return ResponseEntity.ok().body(produto);
    }


    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<String> deleteUserEntity(@PathVariable Long id, HttpServletRequest request) throws Exception {
        pedidoService.deletePedido(id);
        return ResponseEntity.ok().body("Pedido Deletado");
    }
}

