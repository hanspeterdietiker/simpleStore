package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entities.ClienteModel;



import java.util.Optional;


public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    /*@Modifying
    @Query("UPDATE tb_cliente c SET c.nameClient = :nameClient, c.email = :email WHERE c.id = :id")
    void update(@Param("id") Long id, @Param("nameClient") String nameClient, @Param("email") String email);*/

    Optional<ClienteModel> findById(long id);



}
