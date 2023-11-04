package com.example.simpleStore.dtos;

import java.io.Serializable;

import com.example.simpleStore.entities.clienteModel;
import com.example.simpleStore.entities.compraModel;
import com.example.simpleStore.entities.produtoModel;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class compraDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private clienteModel cliente;
    private produtoModel produto;
    private produtoModel price;
    private int quantidade;
    private BigDecimal valorTotalCompra;

    public compraDto(compraModel entity) {
        this.id = entity.getId();
        this.cliente = entity.getCliente();
        this.produto = entity.getProduto();
        this.price = entity.getPrice();
        this.quantidade = entity.getQuantidade();
        this.valorTotalCompra = entity.valorTotalCompra(quantidade, price);
    }
}
