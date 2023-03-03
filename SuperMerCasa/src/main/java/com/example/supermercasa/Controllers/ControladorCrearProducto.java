package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCrearProducto {

    @Autowired
    public RepositorioOferta repositorioOferta;

    int id = 0;
    @GetMapping("/nuevoProducto")
    public String nuevoProducto(Model model, @RequestParam String nameProd, @RequestParam String description,
                                @RequestParam String price, @RequestParam int nstock, @RequestParam String categoria){
        if(repositorioOferta.getProductoByName(nameProd) == null){
            //el producto no existe, por lo que se puede crear
            repositorioOferta.save(new Producto(id, nameProd, nstock, description, Double.parseDouble(price), null, repositorioOferta.getCategoriaByName(categoria)));
            model.addAttribute("mensajeAddProd", "Producto añadido con éxito");
        }else{
            //el producto existe, por lo que no se puede crear
            model.addAttribute("mensajeAddProd", "Producto ya existente en la base de datos");
        }
        return "administrarProductos";
    }

    @GetMapping("/administrarProductos")
    public String administrarProductos(Model model){
        model.addAttribute("mensajeAddProd", "");

        return "administrarProductos";
    }
}
