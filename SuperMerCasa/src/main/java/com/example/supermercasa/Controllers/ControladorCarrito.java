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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        List<Producto> l = carrito.getListaProductos();
        List<String> prod = new ArrayList<>();
        List<String> prec = new ArrayList<>();

        for(int i = 0; i < l.size(); i++){
            prod.add(l.get(i).getName());
            prec.add(l.get(i).getPrecio());
        }

        model.addAttribute("productos", prod);
        model.addAttribute("precios", prec);
        return "carrito";
    }

    @GetMapping("/addProducto/{id}")
    public String addProducto(Model model, @PathVariable long id){

        producto = repositorioOferta.findById(id).get();

        Optional<Usuario> user = repositorioUsuario.findById(28L);

        carrito = repositorioCarrito.findByUser(user.get());
        if(carrito == null){
            repositorioCarrito.save(new Carrito(user.get(),producto));
            carrito = repositorioCarrito.findByUser(user.get());
            model.addAttribute("productos", carrito.getListaProductos().get(0).getName());
        }
       else{
            List<Producto> l = carrito.getListaProductos();
            List<String> s = new ArrayList<>();
            l.add(producto);
            for(int i = 0; i < l.size(); i++){
                s.add(l.get(i).getName());
            }
            model.addAttribute("productos", s);
            repositorioCarrito.findByUser(user.get()).setListaProductos(l);
            repositorioCarrito.flush();
       }

        return "carrito";
    }
}
