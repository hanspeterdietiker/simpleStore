package com.example.simpleStore.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "tb_produto")
@Getter
@Setter
public class produtoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_Produto")
    private Long id;

    @Column(name = "nome_Produto")
    private String nameProduct;

    @Column(name = "preco_Produto")
    private float price;

    

}
