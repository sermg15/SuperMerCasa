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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    @OneToMany
    private List<Producto> productos;

    public Categoria(){}

    public Categoria (String nombre, Producto productos){

        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.productos.add(productos);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre () {return nombre;}

    public void setNombre (String nombre) {this.nombre = nombre;}

    public List<Producto> getProductos() {return productos;}

    public void setProductos (List<Producto> productos) {this.productos = productos;}

    public void añadirProducto (Producto producto) {this.productos.add(producto);}
}
