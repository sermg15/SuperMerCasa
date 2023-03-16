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

    @ElementCollection
    private List<Integer> cantidades = new ArrayList<>();

    @ManyToOne
    private Usuario user;

    private String estado;
    private double precioTotal;



    public Pedido(){}



    public Pedido(List<Producto> productos, Usuario user, String estado, double precioTotal, List<Integer> cantidadProductos){

        this.productos.addAll(productos);
        this.user = user;
        this.estado = estado;
        this.precioTotal=precioTotal;
        this.cantidades.addAll(cantidadProductos);

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

    public String printPedido()
    {
        String productoCantidadPrecio ="LISTA DE PRODUCTOS: <br />";
        for(int i = 0; i < productos.size(); i++){
            productoCantidadPrecio += ("Producto: " + productos.get(i).getName() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unidades: " + cantidades.get(i) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Precio/unidad: " + productos.get(i).getPrecio() + "<br />");
        }
        return productoCantidadPrecio;
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

    public double getPrecioTotal() {return precioTotal;}

    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;}

    public List<Integer> getCantidades() {return cantidades;}

    public void setCantidades(List<Integer> cantidadProductos) {this.cantidades = cantidadProductos;}



}
