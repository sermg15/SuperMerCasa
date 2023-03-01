package com.example.supermercasa.Entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long iden;
    private String nombreUsuario;
    private String email;
    private String contraseña;
    private String direction;
    @OneToOne
    private Carrito carrito;
    @OneToMany
    private List<Pedido> pedidos;

    public Usuario(){}




    public Usuario(long iden, String nombreUsuario, String email, String direction, String contraseña, Carrito carrito, List<Pedido> pedidos){

        this.iden = iden;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.email = email;
        this.direction = direction;
        this.carrito = carrito;
        this.pedidos = pedidos;
    }

    public long getId() {
        return iden;
    }

    public void setId(long id) {
        this.iden = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirecction() {
        return direction;
    }

    public void setDirecction(String direction) {
        this.direction = direction;
    }

    public Carrito getCarrito() {return carrito;}

    public void setCarritos(Carrito carrito) {this.carrito = carrito;}

    public List<Pedido> getPedidos() { return pedidos;}

    public void setPedidos(List<Pedido> pedidos) {this.pedidos = pedidos;}


}
