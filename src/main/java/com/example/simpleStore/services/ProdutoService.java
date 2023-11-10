package com.example.simpleStore.services;

import com.example.simpleStore.entities.ProdutoModel;
import com.example.simpleStore.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel createProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    public Optional<ProdutoModel> getById(@PathVariable Long id) throws Exception {
        if (produtoRepository.findById(id).isEmpty()) {
            throw new Exception("Id do produto não encontrada no Banco de Dados");
        } else {
            return produtoRepository.findById(id);
        }

    }

    public List<ProdutoModel> getAllProdutos() throws Exception {
        if (produtoRepository.findAll().isEmpty()) {
            throw new Exception("Produtos não encontrados no Banco de Dados");
        } else {
            return produtoRepository.findAll();
        }
    }

    public void deleteProduct(@PathVariable Long id) throws Exception {
        if (produtoRepository.findById(id).isEmpty()) {
              throw new Exception("Id do produto não encontrada no Banco de Dados");
        }
        produtoRepository.existsById(id);
        produtoRepository.deleteById(id);
    }

}

