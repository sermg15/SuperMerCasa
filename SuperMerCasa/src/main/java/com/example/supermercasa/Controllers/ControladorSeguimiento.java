package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Entidades.Pedido;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import com.example.supermercasa.Repositorios.RepositorioPedido;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.example.supermercasa.Repositorios.RepositorioCarrito;


import java.util.List;
import java.util.Optional;

@Controller
public class ControladorSeguimiento {
    @Autowired
    RepositorioCarrito repositorioCarrito;
    @Autowired
    RepositorioUsuario repositorioUsuario;
    @Autowired
    RepositorioPedido repositorioPedido;

    @GetMapping("/addSeguimiento")
    public String addSeguimiento(Model model){

        Optional<Usuario> user = repositorioUsuario.findById(28L);
        List<Producto> productos = repositorioCarrito.findByUser(user.get()).getListaProductos();
        repositorioPedido.save(new Pedido(1,productos,user.get(),"Recibido"));
        model.addAttribute("estado",repositorioPedido.findById(30L).get().getEstado());



        return "seguimientoPedidos";
    }

    @GetMapping("/seguimiento")
    public String Seguimiento(Model model){

        model.addAttribute("estado","Pedido no encontrado");

        return "seguimientoPedidos";
    }


}
