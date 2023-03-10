package com.example.supermercasa.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long iden;
    private String nombreUsuario;
    private String email;
    private String contraseñaCifrada;
    private String direction;
    @OneToOne
    private Carrito carrito;
    @OneToMany
    private List<Pedido> pedidos;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public Usuario(){}




    public Usuario(String nombreUsuario, String email, String direction, String contraseña, Carrito carrito, List<Pedido> pedidos, String... rol){

        this.iden = iden;
        this.nombreUsuario = nombreUsuario;
        this.contraseñaCifrada = contraseña;
        this.email = email;
        this.direction = direction;
        this.carrito = carrito;
        this.pedidos = pedidos;
        roles = List.of(rol);

    }

    public long getId() {
        return iden;
    }

    public void setId(long id) {
        this.iden = id;
    }

    public String getNombreUsuario() { return nombreUsuario; }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseñaCifrada() {
        return contraseñaCifrada;
    }

    public void setContraseñaCifrada(String contraseña) {
        this.contraseñaCifrada = contraseña;
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

    public Pedido getPedido(long id) { return pedidos.get((int) id);}


    public void addPedidos(Pedido pedido){
        pedidos.add(pedido);
    }

    public void setPedidos(List<Pedido> pedidos) {this.pedidos = pedidos;}

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
