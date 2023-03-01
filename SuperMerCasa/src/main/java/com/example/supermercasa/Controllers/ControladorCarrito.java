package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Entidades.Pedido;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import com.example.supermercasa.Repositorios.RepositorioCarrito;
import com.example.supermercasa.Repositorios.RepositorioOferta;
import com.example.supermercasa.Repositorios.RepositorioPedido;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.*;

@Controller
public class ControladorCarrito {

    @Autowired
    private RepositorioOferta repositorioOferta;
    @Autowired
    private RepositorioCarrito repositorioCarrito;
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioPedido repositorioPedido;

    Carrito carrito;
    //Usuario user;
    Producto producto;
    Pedido pedido;

    @GetMapping("/carrito")
    public String Carrito(Model model, @RequestParam String comprado) {

        Optional<Usuario> user = repositorioUsuario.findById(28L);
        carrito = repositorioCarrito.findByUser(user.get());

        if(carrito == null){

            model.addAttribute("productos", null);
            model.addAttribute("precios", null);
            model.addAttribute("cantidad", "");
            model.addAttribute("precioTotal", "0");
            model.addAttribute("comprado", "");
        }else{

            model.addAttribute("productos", carrito.getListaProductos());
            model.addAttribute("precios", carrito.getListaProductos());
            model.addAttribute("cantidad", carrito.getCantidadProductos());
            model.addAttribute("precioTotal", precioTotal);
            model.addAttribute("comprado", comprado);
        }

        return "carrito";
    }


    double precioTotal;

    @GetMapping("/addProducto/{id}")
    public String addProducto(Model model, @PathVariable long id, @RequestParam int cantidad){

        Optional<Usuario> user = repositorioUsuario.findById(28L);
        producto = repositorioOferta.findById(id).get();
        carrito = repositorioCarrito.findByUser(user.get());

        if(carrito == null){

            precioTotal = 0;

            repositorioCarrito.save(new Carrito(user.get(),producto, cantidad));
            carrito = repositorioCarrito.findByUser(user.get());

            precioTotal = producto.getPrecio() * cantidad;
            precioTotal = (double)Math.round(precioTotal * 100) / 100;

            model.addAttribute("productos", carrito.getListaProductos());
            model.addAttribute("precios", carrito.getListaProductos());
            model.addAttribute("cantidad", carrito.getCantidadProductos());
            model.addAttribute("precioTotal", precioTotal);
            model.addAttribute("comprado", "");

        }
       else{

            repositorioCarrito.findByUser(user.get()).aniadirProducto(producto, cantidad);
            repositorioCarrito.flush();

            carrito = repositorioCarrito.findByUser(user.get());

            precioTotal += producto.getPrecio() * cantidad;
            precioTotal = (double)Math.round(precioTotal * 100) / 100;

            model.addAttribute("productos", carrito.getListaProductos());
            model.addAttribute("precios", carrito.getListaProductos());
            model.addAttribute("cantidad", carrito.getCantidadProductos());
            model.addAttribute("precioTotal", precioTotal);
            model.addAttribute("comprado", "");
       }
        return "carrito";
    }
    @GetMapping("/addSeguimiento")
    public String addSeguimiento(Model model, @RequestParam String comprado){

        Optional<Usuario> user = repositorioUsuario.findById(28L);
        carrito = repositorioCarrito.findByUser(user.get());


        if(carrito == null){

            model.addAttribute("productos", null);
            model.addAttribute("precios",null);
            model.addAttribute("cantidad", "");
            model.addAttribute("precioTotal", "0");
            model.addAttribute("comprado", "NO HAY PRODUCTOS SUFICIENTES PARA REALIZAR UN PEDIDO");

        }else{
            repositorioPedido.save(new Pedido(1, carrito.getListaProductos(), user.get(),"Recibido"));
            user.get().getPedidos().add(repositorioPedido.findByUser(user.get()));
            repositorioCarrito.deleteById(carrito.getId());

            model.addAttribute("productos", null);
            model.addAttribute("precios",null);
            model.addAttribute("cantidad", "");
            model.addAttribute("precioTotal", "0");
            model.addAttribute("comprado", comprado);

        }

        return "carrito";
    }
}
