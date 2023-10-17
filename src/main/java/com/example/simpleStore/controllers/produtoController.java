package com.example.simpleStore.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.entity.produtoModel;
import com.example.simpleStore.repositories.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
public class produtoController {
    private final ProdutoRepository produtoRepository;

    public produtoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/search-by-products")
    public List<produtoModel> getAllProdutos(){
        return produtoRepository.findAll();
    }
}
