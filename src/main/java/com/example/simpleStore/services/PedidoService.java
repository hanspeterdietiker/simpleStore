package com.example.simpleStore.services;

import com.example.simpleStore.entities.PedidoModel;
import com.example.simpleStore.repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {


    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoModel createProduto(PedidoModel produto) {
        return pedidoRepository.save(produto);
    }

    public Optional<PedidoModel> getById(@PathVariable Long id) throws Exception {
        if (pedidoRepository.findById(id).isEmpty()) {
            throw new Exception("Id do Pedido não encontrada no Banco de Dados");
        } else {
            return pedidoRepository.findById(id);
        }

    }


    public void deleteProduct(@PathVariable Long id) throws Exception {
        if (pedidoRepository.findById(id).isEmpty()) {
            throw new Exception("Id do Pedido não encontrada no Banco de Dados");
        }
        pedidoRepository.existsById(id);
        pedidoRepository.deleteById(id);
    }

}

