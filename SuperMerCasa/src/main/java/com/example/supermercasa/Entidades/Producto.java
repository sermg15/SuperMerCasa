package com.example.supermercasa.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int stock;

    private String descripcion;
    private double precio;

    private String imagen;

    @ManyToMany
    private List<Categoria> categorias;



    public Producto(String name, int stock, String descripcion, double precio, String imagen, Categoria categoria){

        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
        this.categorias = new ArrayList<>();
        this.categorias.add(categoria);

    }

    public Producto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void addCategoria(Categoria categoria){this.categorias.add(categoria);}

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void subStock(int cantidad){

        this.stock -= cantidad;
    }
}

