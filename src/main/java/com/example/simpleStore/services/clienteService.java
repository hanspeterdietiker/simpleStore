package com.example.simpleStore.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.simpleStore.dtos.clienteDto;
import com.example.simpleStore.entities.clienteModel;
import com.example.simpleStore.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class clienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public clienteModel createClient(clienteModel cliente) throws Exception {
        clienteModel newCliente = new clienteModel(
                cliente.getId(), cliente.getNameClient(), cliente.getEmail(), cliente.getPassword());
        if (newCliente == null) {
            throw new Exception("Por favor informe corretamente");

        } else {
            this.clienteRepository.save(newCliente);
            return newCliente;
        }
    }

    public clienteDto update(@PathVariable long id, clienteModel updateClient) throws Exception {
        List<clienteModel> ListClient = clienteRepository.findById(id);

        if (ListClient.isEmpty()) {
            throw new EntityNotFoundException("Id não encontrada");

        } else {
            clienteModel existingClient = ListClient.get(0);

            existingClient.setNameClient(updateClient.getNameClient());
            existingClient.setEmail(updateClient.getEmail());

            clienteModel updatedClient = clienteRepository.save(existingClient);

            clienteDto responseDto = new clienteDto(updatedClient.getNameClient(), updatedClient.getEmail());

            return responseDto;
        }
    }

    public List<clienteModel> getById(@PathVariable long id) {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Id não encontrada");
        } else {
            return clienteRepository.findById(id);
        }
    }

    public List<clienteModel> getAllClientes() {
        if (clienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Usúario não encontrado");
        } else {
            return clienteRepository.findAll();
        }
    }

    public void deleteClient(@PathVariable long id) {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Id não encontrada");
        } else {
            clienteRepository.existsById(id);
            clienteRepository.deleteById(id);
        }
    }
}
