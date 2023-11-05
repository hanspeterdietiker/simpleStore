package com.example.simpleStore.dtos;

import java.io.Serializable;

import com.example.simpleStore.entities.clienteModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class clienteDto implements Serializable {
   
    private long id;
    private String nameClient;
    private String email;

    public clienteDto(clienteModel entity) {
        this.id = entity.getId();
        this.nameClient = entity.getNameClient();
        this.email = entity.getEmail();
    }
}
