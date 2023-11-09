package com.example.simpleStore.services;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
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


    public clienteModel update(@PathVariable long id, clienteModel updateClient) throws Exception {
        var existingClient = clienteRepository.getReferenceById(id);
        if (existingClient != null) {
            existingClient.setNameClient(updateClient.getNameClient());
            existingClient.setEmail(updateClient.getEmail());
            return clienteRepository.save(existingClient);
        } else {
            throw new Exception("Id não encontrada no Banco de Dados");
        }


    }


    public Optional<clienteModel> getById(@PathVariable long id) throws Exception {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new Exception("Id não encontrada no Banco de Dados");

        } else {
            return clienteRepository.findById(id);
        }
    }

    public List<clienteModel> getAllClientes() throws Exception {
        if (clienteRepository.findAll().isEmpty()) {
            throw new Exception("Usuarios não encontrado no Banco de Dados");
        } else {
            return clienteRepository.findAll();
        }
    }

    public void deleteClient(@PathVariable long id) throws Exception {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new Exception("Id não encontrada no Banco de Dados");
        } else {
            clienteRepository.existsById(id);
            clienteRepository.deleteById(id);
        }
    }
}
