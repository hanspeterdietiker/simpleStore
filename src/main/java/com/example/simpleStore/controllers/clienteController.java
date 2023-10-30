package com.example.simpleStore.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.entity.clienteModel;
import com.example.simpleStore.repositories.ClienteRepository;



@RestController
@RequestMapping("/clientes")
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
}
