package com.example.supermercasa.Entidades;

import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.Type;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    private List<Integer> cantidadProductos = new ArrayList<>();

    @OneToMany
    private List<Producto> listaProductos;

    @OneToOne
    private Usuario user;

    public Carrito(){}

    public Carrito (Usuario user){
        this.user = user;
        this.listaProductos = new ArrayList<>();
    }
    public Carrito (Usuario user, Producto producto, int cantidad){
        this.user = user;
        listaProductos = new ArrayList<>();
        this.listaProductos.add(producto);
        cantidadProductos.add(cantidad);
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

    public void aniadirProducto (Producto producto, int cantidad) {
        this.listaProductos.add(producto);
        this.cantidadProductos.add(cantidad);
    }

    public List<Integer> getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(List<Integer> cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public void addCantidades(int cantidad, int index){

        cantidad += this.cantidadProductos.get(index);
        this.cantidadProductos.set(index, cantidad);
    }

}
