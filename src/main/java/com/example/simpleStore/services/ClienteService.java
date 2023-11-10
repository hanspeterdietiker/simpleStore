package com.example.simpleStore.services;


import com.example.simpleStore.dtos.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import com.example.simpleStore.entities.ClienteModel;
import com.example.simpleStore.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteModel createClient(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }


    public ClienteModel update(@PathVariable Long id, ClienteDto updateClient) throws Exception {
        var existingClient = clienteRepository.getReferenceById(id);
        if (existingClient != null) {
            existingClient.setNameClient(updateClient.getNameClient());
            existingClient.setEmail(updateClient.getEmail());
            return clienteRepository.save(existingClient);
        } else {
            throw new Exception("Id não encontrada no Banco de Dados");
        }


    }


    public Optional<ClienteModel> getById(@PathVariable Long id) throws Exception {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new Exception("Id do Cliente não encontrada no Banco de Dados");

        } else {
            return clienteRepository.findById(id);
        }
    }

    public List<ClienteModel> getAllClientes() throws Exception {
        if (clienteRepository.findAll().isEmpty()) {
            throw new Exception("Usuarios não encontrados no Banco de Dados");
        } else {
            return clienteRepository.findAll();
        }
    }

    public void deleteClient(@PathVariable Long id) throws Exception {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new Exception("Id não encontrada no Banco de Dados");
        } else {
            clienteRepository.existsById(id);
            clienteRepository.deleteById(id);
        }
    }
}
