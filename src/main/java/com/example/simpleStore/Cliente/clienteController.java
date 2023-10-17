package com.example.simpleStore.Cliente;

import java.util.List;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class clienteController {
    private Icliente icliente;

    public clienteController(Icliente icliente) {
        this.icliente = icliente;
    }

    @PostMapping("/")
    public List<clienteModel> getAllClientes() {
        return icliente.findAll();

    }
}
