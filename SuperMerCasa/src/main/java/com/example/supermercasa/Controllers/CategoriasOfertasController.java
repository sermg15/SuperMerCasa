package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Categoria;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.RepositorioCategoria;
import com.example.supermercasa.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class CategoriasOfertasController {
    @Autowired
    private RepositorioProducto repositorioProducto;

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @GetMapping("/categoria")
    public String Categorias(Model model, String cat) {

        model.addAttribute("categoria", cat);

        if(repositorioProducto.findByCategoriasNombre(cat).isEmpty() == false){
            List<Producto> productos = repositorioProducto.findByCategoriasNombre(cat);
            model.addAttribute("productos", productos);
        }else{

        }

        return "categorias";
    }

    @GetMapping("/ofertas")
    public String ofertas(Model model){

        if(repositorioProducto.findByCategoriasNombre("Ofertas").isEmpty() == false){
            List<Producto> productos = repositorioProducto.findByCategoriasNombre("Ofertas");
            model.addAttribute("productos", productos);
        }

        return "ofertas";
    }
}
