package com.example.simpleStore.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name = "tb_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_Cliente")
    private Long id;

    @Column(name = "nome_Cliente")
    private String nameClient;

    @Column(name = "email_Cliente")
    private String email;


    @Column(name = "senha_Cliente")
    private String password;


    @JsonIgnore
    @OneToMany
    @Column(name = "pedidos_cliente")
    private List<PedidoModel> pedidos = new ArrayList<>();

    public ClienteModel() {
    }
    public ClienteModel(Long id, String nameClient, String email, String password) {
        this.id = id;
        this.nameClient = nameClient;
        this.email = email;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteModel that = (ClienteModel) o;
        return Objects.equals(id, that.id) && Objects.equals(nameClient, that.nameClient) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameClient, email);
    }

    public List<PedidoModel> getPedidos() {
        return pedidos;
    }

    public Long getId() {
        return this.id;
    }

    public String getNameClient() {
        return this.nameClient;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
