package com.example.simpleStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.simpleStore.dtos.clienteDto;
import com.example.simpleStore.entities.clienteModel;
import com.example.simpleStore.repositories.ClienteRepository;

@Service
public class clienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public boolean addClient(clienteDto cliente){
        clienteModel newCliente = new clienteModel(cliente.getNameClient(), cliente.getEmail());
        clienteModel clienteSave= this.clienteRepository.save(newCliente);

        if (clienteSave != null){
            return true;
        } else{
            return false;
        }
    }

}
