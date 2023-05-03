package com.example.supermercasa.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @LazyCollection(LazyCollectionOption.FALSE)

    private List<Producto> productos;

    public Categoria(){}

    public Categoria (String nombre){

        this.nombre = nombre;
        productos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre () {return nombre;}

    public void setNombre (String nombre) {this.nombre = nombre;}

    @JsonManagedReference
    public List<Producto> getProductos() {return productos;}

    public void setProductos (List<Producto> productos) {this.productos = productos;}

    public void addProductos(Producto producto) {
        this.productos.add(producto);
    }

    public void deleteProducto(Producto producto){this.productos.remove(producto);}
}
