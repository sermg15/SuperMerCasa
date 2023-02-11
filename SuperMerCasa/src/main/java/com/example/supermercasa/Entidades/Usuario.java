package com.example.supermercasa.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String email;
    private String direcction;

    public Usuario(String name, String surname, String email, String direction){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.direcction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirecction() {
        return direcction;
    }

    public void setDirecction(String direction) {
        this.direcction = direcction;
    }
}
