package com.example.simpleStore.entity;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class compraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="id_compra")
    private Long id;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private clienteModel cliente;

    @OneToOne
    @PrimaryKeyJoinColumn
    private produtoModel produto;
    
    @Column(name="qtd_compra")
    private int quantidade;

    
    }


