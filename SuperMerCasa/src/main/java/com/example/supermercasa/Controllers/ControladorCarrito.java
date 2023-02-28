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

    List<String> s = new ArrayList<>();
    List<String> p = new ArrayList<>();
    List<Integer> c = new ArrayList<>();

    @GetMapping("/carrito")
    public String Carrito(Model model) {

        //List<Producto> l = carrito.getListaProductos();

        model.addAttribute("productos", s);
        model.addAttribute("precios",p);
        model.addAttribute("cantidad", c);
        model.addAttribute("precioTotal", decimalFormat.format(precioTotal));
        return "carrito";
    }



    float precioTotal;
    float precioAux;

    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @GetMapping("/addProducto/{id}")
    public String addProducto(Model model, @PathVariable long id, @RequestParam int cantidad){

        producto = repositorioOferta.findById(id).get();

        Optional<Usuario> user = repositorioUsuario.findById(28L);
        String precioAuxString = "";

        if(carrito == null){
            repositorioCarrito.save(new Carrito(user.get(),producto));
            carrito = repositorioCarrito.findByUser(user.get());
            precioAux = Float.parseFloat(producto.getPrecio()) * cantidad;
            precioAuxString += decimalFormat.format(precioAux);
            c.add(cantidad);
            s.add(producto.getName());
            p.add(precioAuxString);
            precioTotal = precioAux;

            model.addAttribute("productos", s.get(0));
            model.addAttribute("precios", p.get(0));
            model.addAttribute("cantidad", c.get(0));
            model.addAttribute("precioTotal", decimalFormat.format(precioTotal));

        }
       else{
            List<Producto> l = carrito.getListaProductos();

            precioAux = Float.parseFloat(producto.getPrecio()) * cantidad;
            precioAuxString += decimalFormat.format(precioAux);

            l.add(producto);

            s.add(producto.getName());
            p.add(precioAuxString);

            c.add(cantidad);

            precioTotal += precioAux;

            model.addAttribute("productos", s);
            model.addAttribute("precios",p);
            model.addAttribute("cantidad", c);
            model.addAttribute("precioTotal", decimalFormat.format(precioTotal));

            repositorioCarrito.findByUser(user.get()).setListaProductos(l);
            repositorioCarrito.flush();
       }

        return "carrito";
    }
}
