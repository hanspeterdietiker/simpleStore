package com.example.simpleStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleStore.entities.clienteModel;
import java.util.List;

public interface ClienteRepository extends JpaRepository<clienteModel, Long> {
    List<clienteModel> findById(long id);

    clienteModel findByNameClient(String nameClient);

    clienteModel findByEmail(String email);

    clienteModel update(long id, clienteModel client);
}
