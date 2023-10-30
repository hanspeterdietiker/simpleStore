package com.example.simpleStore.controllers;


import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/registering-products")
    public ResponseEntity <produtoModel> create(@RequestBody produtoModel ProdutoModel){
        if ( ProdutoModel != null ) {
            produtoModel novoProduto = produtoRepository.save(ProdutoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search-by-products")
    public List<produtoModel> getAllProdutos(){
        return produtoRepository.findAll();
    }
}
