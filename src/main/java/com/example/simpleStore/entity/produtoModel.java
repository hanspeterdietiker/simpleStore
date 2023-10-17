package com.example.simpleStore.Produto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity(name = "tb_produto")
@Data
public class produtoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_Produto")
    private Long id;

    @Column(name = "nome_Produto")
    private String name;

    @Column(name = "preco_Produto")
    private float price;

    

}
