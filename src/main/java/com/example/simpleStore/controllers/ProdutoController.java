package com.example.simpleStore.controllers;

import java.util.List;
import java.util.Optional;

import com.example.simpleStore.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleStore.entities.ProdutoModel;


@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {


    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping("/registering-product")
    public ResponseEntity<ProdutoModel> create(@RequestBody @Valid ProdutoModel produto) {
        var newProduto = new ProdutoModel(produto.getId(),produto.getNameProduct(), produto.getPrice());
        produtoService.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
    }


    @GetMapping("/searching-by-product/{id}")
    public ResponseEntity<Optional<ProdutoModel>> getById(@PathVariable Long id) throws Exception {
        var produto = produtoService.getById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/searching-by-products")
    public List<ProdutoModel> getAllProdutos() throws Exception {
        return produtoService.getAllProdutos();
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<String> deleteUserEntity(@PathVariable Long id) throws Exception {
        produtoService.deleteProduct(id);
        return ResponseEntity.ok().body("Produto Deletado");
    }
}

