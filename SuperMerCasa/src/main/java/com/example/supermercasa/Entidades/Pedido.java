package com.example.supermercasa.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private List<Producto> productos = new ArrayList<>();

    @ManyToOne
    private Usuario user;

    private String estado;

    public Pedido(){}

    public Pedido(long id, List<Producto> productos, Usuario user, String estado){

        this.id = id;
        this.productos.addAll(productos);
        this.user = user;
        this.estado = estado;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void cambiarEstado (String estado){
        this.estado = estado;
    }
}
