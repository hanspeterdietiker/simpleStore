package com.example.simpleStore.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_Compras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class compraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_compra")
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private clienteModel cliente;

    @OneToOne
    @PrimaryKeyJoinColumn
    private produtoModel produto;

    @OneToOne
    @PrimaryKeyJoinColumn
    private produtoModel price;

    @Column(name = "quantidadeProduto")
    private int quantidade;

    
    @Column(name = "horarioDeCompra")
    @CreationTimestamp
    private LocalDateTime purchasedAt;

    public BigDecimal valorTotalCompra(int quantidade, produtoModel price) {
        BigDecimal preco = price.getPrice();
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }

}
