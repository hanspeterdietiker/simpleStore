package com.example.simpleStore.dtos;

import java.io.Serial;
import java.io.Serializable;



import com.example.simpleStore.entities.CompraModel;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompraDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private int quantidade;
    private BigDecimal valorTotalCompra;

    public CompraDto(CompraModel entity) {
        this.id = entity.getId();
        this.quantidade = entity.getQuantidade();

    }

}
