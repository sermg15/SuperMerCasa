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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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

    Carrito carrito;
    Pedido pedido;

    List<Pedido> pedidos;



    @GetMapping("/seguimientoPedido")
    public String Seguimiento(Model model, HttpServletRequest request){

        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user = repositorioUsuario.findByNombreUsuario(principal.getName());

        pedidos = user.get().getPedidos();
        model.addAttribute("pedidos",pedidos);
        return "seguimientoPedidosEleccion";
    }

    @GetMapping("/seguimientoPedido/{id}")
    public String SeguimientoPedido(Model model,@PathVariable long id, HttpServletRequest request){

        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user = repositorioUsuario.findByNombreUsuario(principal.getName());

        pedido = repositorioPedido.findByUserAndId(user, id);

        if(pedido == null){
            model.addAttribute("id", "NO HAY PEDIDOS");
            model.addAttribute("estado","Pedido no encontrado");


        }else{

            model.addAttribute("productos",pedido.getProductos());
            model.addAttribute("precios",pedido.getProductos());
            model.addAttribute("cantidad",pedido.getCantidades());
            model.addAttribute("estado",pedido.getEstado());
            model.addAttribute("precioTotal", pedido.getPrecioTotal());
        }
        return "seguimientoPedidos";
    }


}
