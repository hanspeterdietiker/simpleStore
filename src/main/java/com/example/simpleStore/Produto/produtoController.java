package com.example.simpleStore.Produto;


import java.util.List;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produtos")
public class produtoController {
    private final IProduto iproduto;

    public produtoController(IProduto iproduto){
        this.iproduto = iproduto;
    }

    @PostMapping("/")
    public List<produtoModel> getAllProdutos(){
        return iproduto.findAll();
    }
}
