package com.example.simpleStore.Compra;

import com.example.simpleStore.Cliente.clienteModel;
import com.example.simpleStore.Produto.produtoModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
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
    
    @Column(name="qtd_Compra")
    private int quantidade;

}
