package com.example.simpleStore.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.dtos.clienteDto;
import com.example.simpleStore.entities.clienteModel;
import com.example.simpleStore.repositories.ClienteRepository;
import com.example.simpleStore.services.clienteService;
@RestController
@RequestMapping("/api/v1/client")
public class clienteController {

    private final ClienteRepository clienteRepository;

    public clienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/register-client")
    public ResponseEntity create(@RequestBody clienteModel clModel) {
        var client = this.clienteRepository.findByNameClient(clModel.getNameClient());

        var emailClient = this.clienteRepository.findByEmail(clModel.getEmail());

        if (emailClient != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email ja cadastrado no banco de dados");
        }

        if (client != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente ja foi registrado no banco de dados");
        }

        var clientCadastrado = this.clienteRepository.save(clModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientCadastrado);

    }

    @PutMapping("/update-client/{id}")
    public ResponseEntity<clienteDto> update(@PathVariable Long id, @RequestBody clienteModel updateClient) {
        clienteModel existingClient = clienteRepository.findById(id).orElse(null);

        if (existingClient != null) {
            existingClient.setNameClient(updateClient.getNameClient());

            existingClient.setEmail(updateClient.getEmail());

            clienteModel updatedClient = clienteRepository.save(existingClient);

            clienteDto responseDto = new clienteDto(updatedClient.getNameClient(), updatedClient.getEmail());
            return ResponseEntity.ok().body(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/searching-by-clients")
    public List<clienteModel> getAllClientes() {
        return clienteRepository.findAll();

    }

    @GetMapping("/searching-by-client/{id}")
    public ResponseEntity<List<clienteModel>> searchById(@PathVariable long id, clienteService service) {
        var cliente = service.getById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/delete-client/{id}")
    public ResponseEntity<String> deleteUserEntity(@PathVariable long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

    }
}
