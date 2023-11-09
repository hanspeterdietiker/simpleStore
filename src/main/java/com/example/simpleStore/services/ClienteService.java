package com.example.simpleStore.services;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import com.example.simpleStore.dtos.clienteDto;
import com.example.simpleStore.entities.clienteModel;
import com.example.simpleStore.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public clienteModel createClient(clienteModel cliente) {
        return clienteRepository.save(cliente);
    }


    public clienteModel update(@PathVariable long id, clienteModel updateClient) {
        var existingClient = clienteRepository.getReferenceById(id);
        if (existingClient != null) {
            existingClient.setNameClient(updateClient.getNameClient());
            existingClient.setEmail(updateClient.getEmail());
            return clienteRepository.save(existingClient);
        } else {
            throw new NullPointerException();
        }


    }


    public List<clienteModel> getById(@PathVariable long id) {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new NullPointerException("Id não encontrada");

        } else {
            return clienteRepository.findById(id);
        }
    }

    public List<clienteModel> getAllClientes() {
        if (clienteRepository.findAll().isEmpty()) {
            throw new NullPointerException("Usúario não encontrado");
        } else {
            return clienteRepository.findAll();
        }
    }

    public void deleteClient(@PathVariable long id) {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new NullPointerException("Id não encontrada");
        } else {
            clienteRepository.existsById(id);
            clienteRepository.deleteById(id);
        }
    }
}
