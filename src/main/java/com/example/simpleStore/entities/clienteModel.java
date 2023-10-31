package com.example.simpleStore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class clienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

    @Column(name = "id_Cliente")
    private long id;

    @Column(name = "nome_Cliente")
    private String nameClient;

    @Column(name = "email_Cliente")
    private String email;

    @Column(name = "senha_Cliente")
    private String password;

}
