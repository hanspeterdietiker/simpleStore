package com.example.simpleStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    public String toString( int quantidade, produtoModel nameProduct, clienteModel nameClient){
        return "Cliente:" +getCliente() + "Produto:" + getProduto() + "Quantidade:" + getQuantidade();
    }

}
