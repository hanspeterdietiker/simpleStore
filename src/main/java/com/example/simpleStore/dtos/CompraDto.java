package com.example.simpleStore.dtos;

import java.io.Serial;
import java.io.Serializable;

import com.example.simpleStore.entities.ClienteModel;
import com.example.simpleStore.entities.CompraModel;
import com.example.simpleStore.entities.ProdutoModel;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompraDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private ClienteModel cliente;
    private ProdutoModel produto;
    private ProdutoModel price;
    private int quantidade;
    private BigDecimal valorTotalCompra;

    public CompraDto(CompraModel entity) {
        this.id = entity.getId();
        this.cliente = entity.getCliente();
        this.produto = entity.getProduto();
        this.price = entity.getPrice();
        this.quantidade = entity.getQuantidade();
        this.valorTotalCompra = entity.valorTotalCompra(quantidade, price);
    }

    public CompraDto(ClienteModel cliente, ProdutoModel price, int quantidade) {
    }
}
