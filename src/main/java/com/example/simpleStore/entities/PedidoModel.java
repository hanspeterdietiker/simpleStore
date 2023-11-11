package com.example.simpleStore.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "tb_produto")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_Produto")
    private Long id;

    @Column(name = "nome_Produto")
    private String nameProduct;

    @Column(name = "preco_Produto")
    private BigDecimal price;

    @Column(name = "quantidade_Produto")
    private int quantidade;

    @Column(name = "valor_Total_Compra")
    private BigDecimal valorTotalCompra;

    public LocalDateTime getCompradoAt() {
        return compradoAt;
    }

    public void setCompradoAt(LocalDateTime compradoAt) {
        this.compradoAt = compradoAt;
    }

    @CreationTimestamp
    private LocalDateTime compradoAt;

    public PedidoModel() {

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal valorTotalCompra() {
        BigDecimal preco = getPrice();
        return preco.multiply(BigDecimal.valueOf(getQuantidade()));
    }

    public BigDecimal getValorTotalCompra() {
        return valorTotalCompra;
    }


    public void setValorTotalCompra(BigDecimal valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }


    public PedidoModel(Long id, String nameProduct, BigDecimal price, int quantidade, LocalDateTime compradoAt) {
        this.compradoAt= compradoAt;
        this.quantidade = quantidade;
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
    }


    public Long getId() {
        return this.id;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
