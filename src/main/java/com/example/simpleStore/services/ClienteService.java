package com.example.simpleStore.services;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.simpleStore.dtos.ClienteDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import com.example.simpleStore.entities.ClienteModel;
import com.example.simpleStore.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteModel createClient(ClienteModel cliente) {
        var passwordHashred = BCrypt.withDefaults().hashToString(12, cliente.getPassword().toCharArray());
        cliente.setPassword(passwordHashred);
        ClienteModel clientCreated = this.clienteRepository.save(cliente);
        return clientCreated;
    }


    public ClienteModel update(@PathVariable Long id, ClienteDto updateClient)   {

        var existingClient = clienteRepository.getReferenceById(id);
        if (existingClient != null) {
            existingClient.setNameClient(updateClient.getNameClient());
            existingClient.setEmail(updateClient.getEmail());
            return clienteRepository.save(existingClient);
        } else {
            throw new EntityNotFoundException("Id não encontrada no Banco de Dados");
        }



    }


    public Optional<ClienteModel> getById(@PathVariable Long id)   {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Id do Cliente não encontrada no Banco de Dados");

        } else {
            return clienteRepository.findById(id);
        }
    }


    public void deleteClient(@PathVariable Long id)   {
        if (clienteRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Id não encontrada no Banco de Dados");
        } else {
            clienteRepository.existsById(id);
            clienteRepository.deleteById(id);
        }
    }
}
