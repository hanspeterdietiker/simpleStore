package com.example.simpleStore.Cliente;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class clienteController {
    private ClienteRepository clienteRepository;

    public clienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/search-by-client")
    public List<clienteModel> getAllClientes() {
        return clienteRepository.findAll();

    }
}
