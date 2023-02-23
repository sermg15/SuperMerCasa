package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import com.example.supermercasa.Repositorios.RepositorioCarrito;
import com.example.supermercasa.Repositorios.RepositorioOferta;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCarrito {

    @Autowired
    private RepositorioOferta repositorioOferta;
    @Autowired
    private RepositorioCarrito repositorioCarrito;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    Carrito carrito;
    Usuario user;
    Producto producto;

    @GetMapping("/carrito")
    public String Carrito(Model model) {

        model.addAttribute("producto",repositorioCarrito.findAll());
        return "carrito";
    }

    @PostMapping("/addProducto/{id}")
    public String addProducto(Model model, @PathVariable long id){

        producto = repositorioOferta.findById(id).get();

        user = repositorioUsuario.findByNombreUsuario(username).get(0);

        if(repositorioCarrito.findByUser(username)==null){
            repositorioCarrito.save(new Carrito(user,producto));
        }
        else{
            carrito.getListaProductos().add(producto);
            repositorioCarrito.save(carrito);
        }
        return "carrito";
    }
}
