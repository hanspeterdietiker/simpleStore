package com.example.simpleStore.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity(name = "tb_Compras")
public class CompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_compra")
    private Long id;


    @Column(name = "horarioDeCompra")
    @CreationTimestamp
    private LocalDateTime purchasedAt;

    public CompraModel(Long id, LocalDateTime purchasedAt) {
        this.id = id;
        this.purchasedAt = purchasedAt;
    }

    public CompraModel() {
    }


    public Long getId() {
        return this.id;
    }


    public LocalDateTime getPurchasedAt() {
        return this.purchasedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setPurchasedAt(LocalDateTime purchasedAt) {
        this.purchasedAt = purchasedAt;
    }
}
