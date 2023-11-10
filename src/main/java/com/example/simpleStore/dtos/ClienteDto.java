package com.example.simpleStore.dtos;

import java.io.Serializable;

import com.example.simpleStore.entities.ClienteModel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nameClient;
    private String email;

    public ClienteDto(ClienteModel entity){
        
        this.nameClient = entity.getNameClient();
        this.email = entity.getEmail();
    }

    
}
