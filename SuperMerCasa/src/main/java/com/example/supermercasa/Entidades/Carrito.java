package com.example.supermercasa.Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Id;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Producto> listaProductos;

    @OneToOne
    private Usuario user;

    public Carrito(){}

    public Carrito (Usuario user){
        this.user = user;
        this.listaProductos = new ArrayList<>();
    }
    public Carrito (Usuario user, Producto product){
        this.user = user;
        this.listaProductos = new ArrayList<>();
        this.listaProductos.add(product);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario () {return user;}

    public void setUsuario (Usuario user) {this.user = user;}

    public List<Producto> getListaProductos() {return listaProductos;}

    public void setListaProductos (List<Producto> listaProductos) {this.listaProductos = listaProductos;}

    public void añadirProducto (Producto producto) {this.listaProductos.add(producto);}
}
