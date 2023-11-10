package com.example.simpleStore.services;


import com.example.simpleStore.entities.CompraModel;
import com.example.simpleStore.repositories.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }


    public CompraModel createCompra(CompraModel compra) {
        return compraRepository.save(compra);
    }

    public List<CompraModel> gettAllCompras() throws Exception {
        if (compraRepository.findAll().isEmpty()) {
            throw new Exception("Compra não encontrada no Banco de Dados");
        } else {
            return compraRepository.findAll();
        }
    }
        public Optional<CompraModel> getById(@PathVariable Long id) throws Exception  {
            if(compraRepository.findById(id).isEmpty()){
                throw new Exception("Id da Compra não encontrada no Banco de Dados");
            }
            return compraRepository.findById(id);
        }


}
