package com.example.simpleStore.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.simpleStore.entities.ProdutoModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nameProduct;
    private BigDecimal price;

    public ProdutoDto(ProdutoModel entity) {
        this.id = entity.getId();
        this.nameProduct = entity.getNameProduct();
        this.price = entity.getPrice();

    }

    public ProdutoDto(String nameProduct, BigDecimal price) {
    }

}
