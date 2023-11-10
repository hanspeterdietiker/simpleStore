package com.example.simpleStore.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "tb_Compras")
public class CompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_compra")
    private Long id;


    @Column(name = "quantidadeProduto")
    private int quantidade;


    @Column(name = "horarioDeCompra")
    @CreationTimestamp
    private LocalDateTime purchasedAt;

    public CompraModel(Long id, int quantidade, LocalDateTime purchasedAt) {
        this.id = id;
        this.quantidade = quantidade;
        this.purchasedAt = purchasedAt;
    }

    public CompraModel() {
    }

    public BigDecimal valorTotalCompra(int quantidade, ProdutoModel price) {
        BigDecimal preco = price.getPrice();
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }

    public Long getId() {
        return this.id;
    }


    public int getQuantidade() {
        return this.quantidade;
    }

    public LocalDateTime getPurchasedAt() {
        return this.purchasedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPurchasedAt(LocalDateTime purchasedAt) {
        this.purchasedAt = purchasedAt;
    }
}
