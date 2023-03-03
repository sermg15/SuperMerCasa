package com.example.supermercasa.Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    @ManyToMany
    @JoinTable(
            name = "categoria_producto",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos;

    public Categoria(){}

    public Categoria (String nombre){

        this.nombre = nombre;
        this.productos = new ArrayList<>();
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

    public void addProducto (Producto producto) {this.productos.add(producto);}
}
