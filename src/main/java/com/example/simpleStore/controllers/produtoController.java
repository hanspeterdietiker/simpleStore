package com.example.simpleStore.controllers;

import java.util.List;

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

import com.example.simpleStore.dtos.produtoDto;
import com.example.simpleStore.entities.produtoModel;
import com.example.simpleStore.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produtos")
public class produtoController {

    private final ProdutoRepository produtoRepository;

    public produtoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/registering-product")
    public ResponseEntity<produtoModel> create(@RequestBody produtoModel ProdutoModel) {
        if (ProdutoModel != null) {
            produtoModel novoProduto = produtoRepository.save(ProdutoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/searching-by-product/{id}")
    public List<produtoModel> getById(@PathVariable long id) {
        return produtoRepository.findById(id);
    }

    @GetMapping("/searching-by-products")
    public List<produtoModel> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<String> deleteUserEntity(@PathVariable long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
    }
}
