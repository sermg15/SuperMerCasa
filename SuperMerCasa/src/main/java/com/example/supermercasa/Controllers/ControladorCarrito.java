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

        List<Producto> l = carrito.getListaProductos();
        List<String> prod = new ArrayList<>();
        List<String> prec = new ArrayList<>();
        List<String> cant = new ArrayList<>();

        for(int i = 0; i < l.size(); i++){
            prod.add(l.get(i).getName());
            prec.add(l.get(i).getPrecio());
        }

        model.addAttribute("productos", prod);
        model.addAttribute("precios", prec);
        model.addAttribute("cantidades",cant);
        return "carrito";
    }

    List<Integer> c = new ArrayList<>();
    List<String> s = new ArrayList<>();
    List<String> p = new ArrayList<>();

    @GetMapping("/addProducto/{id}")
    public String addProducto(Model model, @PathVariable long id, @RequestParam int cantidad){

        producto = repositorioOferta.findById(id).get();

        Optional<Usuario> user = repositorioUsuario.findById(28L);

        if(carrito == null){
            repositorioCarrito.save(new Carrito(user.get(),producto, cantidad, producto.getPrecio(), producto.getName()));
            carrito = repositorioCarrito.findByUser(user.get());

            model.addAttribute("productos", carrito.getListaProductos().get(0).getName());
            model.addAttribute("precios",carrito.getListaProductos().get(0).getPrecio());
            model.addAttribute("cantidad", cantidad);
            model.addAttribute("hola", "IF");
        }
       else{

            model.addAttribute("hola", "ELSE");
            List<Producto> l = carrito.getListaProductos();

            l.add(producto);
            s.add(l.get(l.size() - 1).getName());
            p.add(l.get(l.size() - 1).getPrecio());
            c.add(cantidad);

            model.addAttribute("nombres", s);
            model.addAttribute("precios", p);
            model.addAttribute("cantidades", c);

//            for(int i = 0; i < l.size(); i++){
//                s.add(l.get(i).getName());
//                p.add(l.get(i).getPrecio());
//            }

//            model.addAttribute("productos", s);
//            model.addAttribute("precios",p);
//            model.addAttribute("cantidad", c);

            repositorioCarrito.findByUser(user.get()).setListaProductos(l);
            repositorioCarrito.flush();
       }

        return "carrito";
    }
}
