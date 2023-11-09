package com.example.simpleStore.controllers;

import java.util.List;
import java.util.Optional;

import com.example.simpleStore.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/v1/client")
public class clienteController {

    private final ClienteService clienteService;

    public clienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping("/register-client")
    public ResponseEntity createClient(@RequestBody @Valid clienteModel client) {
        var newClient = new clienteModel(client.getNameClient(), client.getEmail());
        clienteService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    @PutMapping("/update-client/{id}")
    public ResponseEntity<clienteDto> update(@PathVariable Long id, @RequestBody clienteModel attClient) throws Exception {
        var updatedClient = clienteService.update(id, attClient);
        return ResponseEntity.ok(new clienteDto(updatedClient.getNameClient(), updatedClient.getEmail()));
    }


    @GetMapping("/searching-by-clients")
    public List<clienteModel> getAllClientes() throws Exception {
        return clienteService.getAllClientes();

    }

    @GetMapping("/searching-by-client/{id}")
    public ResponseEntity<Optional<clienteModel>> searchById(@PathVariable long id) throws Exception {
        var cliente = clienteService.getById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/delete-client/{id}")
    public ResponseEntity<String> deleteUserEntity(@PathVariable long id) throws Exception {
        clienteService.deleteClient(id);
        return  ResponseEntity.ok().body("Cliente deletado");
    }
}
