package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import com.example.supermercasa.Repositorios.RepositorioCarrito;
import com.example.supermercasa.Repositorios.RepositorioOferta;
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

    Carrito carrito;
    //Usuario user;
    Producto producto;


    @GetMapping("/carrito")
    public String Carrito(Model model) {

        Optional<Usuario> user = repositorioUsuario.findById(28L);
        carrito = repositorioCarrito.findByUser(user.get());

        if(carrito == null){

            model.addAttribute("productos", "");
            model.addAttribute("precios","");
            model.addAttribute("cantidad", "");
            model.addAttribute("precioTotal", "0");
        }else{

            model.addAttribute("productos", carrito.getNombreProductos());
            model.addAttribute("precios", carrito.getPreciosProductos());
            model.addAttribute("cantidad", carrito.getCantidadProductos());
            model.addAttribute("precioTotal", precioTotal);
        }

        return "carrito";
    }



    double precioTotal;

    @GetMapping("/addProducto/{id}")
    public String addProducto(Model model, @PathVariable long id, @RequestParam int cantidad){

        Optional<Usuario> user = repositorioUsuario.findById(28L);
        producto = repositorioOferta.findById(id).get();

        if(carrito == null){

            precioTotal = 0;

            repositorioCarrito.save(new Carrito(user.get(),producto, cantidad));
            carrito = repositorioCarrito.findByUser(user.get());

            precioTotal = producto.getPrecio() * cantidad;
            precioTotal = (double)Math.round(precioTotal * 100) / 100;

            model.addAttribute("productos", carrito.getNombreProductos());
            model.addAttribute("precios", carrito.getPreciosProductos());
            model.addAttribute("cantidad", carrito.getCantidadProductos());
            model.addAttribute("precioTotal", precioTotal);

        }
       else{

            repositorioCarrito.findByUser(user.get()).aniadirProducto(producto, cantidad);
            repositorioCarrito.flush();

            carrito = repositorioCarrito.findByUser(user.get());

            precioTotal += producto.getPrecio() * cantidad;
            precioTotal = (double)Math.round(precioTotal * 100) / 100;

            model.addAttribute("productos", carrito.getNombreProductos());
            model.addAttribute("precios", carrito.getPreciosProductos());
            model.addAttribute("cantidad", carrito.getCantidadProductos());
            model.addAttribute("precioTotal", precioTotal);
       }
        return "carrito";
    }
}
