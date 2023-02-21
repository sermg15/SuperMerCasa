package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ControladorProducto {

    @Autowired
    private RepositorioProducto repositorioProducto;

    @PostConstruct
    public void init() {

        //Ofertas
        repositorioProducto.save(new Producto(1, "Carne de Res", 10, "Carne de vacuno con altas propiedades proteicas", "12.99", "/images/imgCarneOFERTA.jpg"));
        repositorioProducto.save(new Producto(2, "Platanos de Canarias", 50, "Platano 100% Canario extraido de las mejores plantaciones", "3.5", "/images/imgPlatanosOFERTA.jpg"));
        repositorioProducto.save(new Producto(3, "Detergente LimpiaFull", 15, "El mejor detergente para tu ropa, olor suave y agradble", "4.99", "/images/imgDetergenteOFERTA.jpg"));

        //Panaderia y reposteria


        //Carnes y Pescados


        //Frutas y Verduras


        //Bebidas


        //Productos de limpieza


        //Congelados
    }

    @GetMapping ("/producto")
    public String Producto(Model model, @RequestParam long id){


        if(repositorioProducto.findById(id).isPresent()){
            model.addAttribute("producto",repositorioProducto.findById(id).get().getName());
            model.addAttribute("precio", repositorioProducto.findById(id).get().getPrecio());
            model.addAttribute("titulo", repositorioProducto.findById(id).get().getName());
            model.addAttribute("descripcion", repositorioProducto.findById(id).get().getDescripcion());
            model.addAttribute("imagen", repositorioProducto.findById(id).get().getImagen());
        }




        return "producto";
    }

    public static byte[] getImage(Path path){

        byte[] data = null;
        try{
            data = Files.readAllBytes(path);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
