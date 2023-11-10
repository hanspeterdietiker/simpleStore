package com.example.simpleStore.dtos;

import java.io.Serial;
import java.io.Serializable;


import com.example.simpleStore.entities.CompraModel;


import java.time.LocalDateTime;

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
    private LocalDateTime purchasedAt;

    public CompraDto(CompraModel entity) {
        this.id = entity.getId();
        this.purchasedAt = entity.getPurchasedAt();

    }

}
