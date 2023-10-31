package com.example.simpleStore.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.entities.clienteModel;
import com.example.simpleStore.repositories.ClienteRepository;

@RestController
@RequestMapping("/client")
public class clienteController {
    private ClienteRepository clienteRepository;

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

    @GetMapping("/search-by-client")
    public List<clienteModel> getAllClientes() {
        return clienteRepository.findAll();

    }

    @DeleteMapping("/delete-client/{id}")
    public ResponseEntity deleteUserEntity(@PathVariable long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

    }
}
