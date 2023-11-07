package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.simpleStore.entities.produtoModel;
import java.util.List;



public interface ProdutoRepository extends JpaRepository<produtoModel, Long>{
    @Modifying
    @Query("UPDATE tb_produto c SET c.nameProduct = :nameProduct, c.price= :price WHERE c.id = :id")
    void updateCliente(@Param("id") Long id, @Param("nameProduct") String nameProduct, @Param("price") String price);
    
    List<produtoModel> findById(long id);
}
