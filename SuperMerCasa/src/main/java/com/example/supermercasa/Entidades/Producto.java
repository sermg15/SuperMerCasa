package com.example.supermercasa.Entidades;

import com.example.supermercasa.Repositorios.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Repositorios.RepositorioOferta;
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

    @OneToMany
    private List<Categoria> categorias;



    public Producto(long id, String name, int stock, String descripcion, double precio, String imagen, Categoria categorias){

        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
        this.categorias = new ArrayList<>();
        this.categorias.add(categorias);
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


}

