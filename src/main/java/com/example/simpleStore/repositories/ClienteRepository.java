package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.simpleStore.entities.clienteModel;

import java.util.Collection;
import java.util.List;

public interface ClienteRepository extends JpaRepository<clienteModel, Long> {
    @Modifying
    @Query("UPDATE tb_cliente c SET c.nameClient = :nameClient, c.email = :email WHERE c.id = :id")
    void updateProduto(@Param("id") Long id, @Param("nameClient") String nameClient, @Param("email") String email);

    List<clienteModel> findById(long id);

    clienteModel findByNameClient(String nameClient);

    clienteModel findByEmail(String email);


}
