package com.example.simpleStore.Cliente;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_cliente")
@Data
public class clienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_Cliente")
    private long id;

    @Column(name = "nome_Cliente")
    private String name;

    @Column(name = "email_Cliente")
    private String email;

}
