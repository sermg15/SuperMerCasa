package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.RepositorioCategoria;
import com.example.supermercasa.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControladorInicial {

    private boolean firsTime = true;
    @Autowired
    private RepositorioProducto repositorioProducto;
    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @GetMapping("/")
    public String inicio(Model model){

        if(firsTime){
            firsTime = false;
            List<Producto> productos = repositorioProducto.findByCategoriasNombre("Ofertas");
            repositorioCategoria.findByNombre("Ofertas").setProductos(productos);

            productos = repositorioProducto.findByCategoriasNombre("Panaderia y Reposteria");
            repositorioCategoria.findByNombre("Panaderia y Reposteria").setProductos(productos);

            productos = repositorioProducto.findByCategoriasNombre("Carnes y Pescados");
            repositorioCategoria.findByNombre("Carnes y Pescados").setProductos(productos);

            productos = repositorioProducto.findByCategoriasNombre("Frutas y Verduras");
            repositorioCategoria.findByNombre("Frutas y Verduras").setProductos(productos);

            productos = repositorioProducto.findByCategoriasNombre("Bebidas");
            repositorioCategoria.findByNombre("Bebidas").setProductos(productos);

            productos = repositorioProducto.findByCategoriasNombre("Productos de Limpieza");
            repositorioCategoria.findByNombre("Productos de Limpieza").setProductos(productos);

            productos = repositorioProducto.findByCategoriasNombre("Congelados");
            repositorioCategoria.findByNombre("Congelados").setProductos(productos);

            repositorioCategoria.flush();
        }

        return "inicio";
    }
}
