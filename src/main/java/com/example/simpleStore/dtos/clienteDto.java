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
    private static final long serialVersionUID = 1L;

    private String nameClient;
    private String email;

    public clienteDto (clienteModel entity){
        
        this.nameClient = entity.getNameClient();
        this.email = entity.getEmail();
    }

    
}
