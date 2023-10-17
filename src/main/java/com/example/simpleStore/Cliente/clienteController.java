package com.example.simpleStore.Cliente;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class clienteController {
    private Icliente icliente;

    public clienteController(Icliente icliente) {
        this.icliente = icliente;
    }

    @GetMapping("/search-by-client")
    public List<clienteModel> getAllClientes() {
        return icliente.findAll();

    }
}
