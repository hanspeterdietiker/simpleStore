package com.example.simpleStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.simpleStore.dtos.clienteDto;
import com.example.simpleStore.entities.clienteModel;
import com.example.simpleStore.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class clienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public clienteModel createClient(clienteModel cliente) {
        clienteModel newCliente = new clienteModel(
                cliente.getId(), cliente.getNameClient(), cliente.getEmail(), cliente.getPassword());
        this.clienteRepository.save(newCliente);
        return newCliente;

    }

    public List<clienteModel> getById(@PathVariable long id) {
        return clienteRepository.findById(id);
    }

    public List<clienteModel> getAllClientes() {
        return clienteRepository.findAll();

    }

}
