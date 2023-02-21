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
        repositorioProducto.save(new Producto(4, "Donut", 15, "El mejor sabor con la receta original de Donuts", "2.5", "/images/donut.jpg"));
        repositorioProducto.save(new Producto(5, "Pan", 75, "Pan recien horneado hecho con masa madre", "0.99", "/images/pan.jpg"));
        repositorioProducto.save(new Producto(6, "Tarta de queso", 10, "Receta original con queso filadelphia y base de galleta María", "12.99", "/images/tarta.jpg"));
        repositorioProducto.save(new Producto(7, "Croissant", 45, "Croissant hecho a partir de la receta original", "1.99", "/images/croissant.jpg"));

        //Carnes y Pescados
        repositorioProducto.save(new Producto(8, "Filete de lomo", 20, "Filete de lomo de la mayor calidad, cerdos 100% ibericos", "6.99", "/images/cerdo.jpg"));
        repositorioProducto.save(new Producto(9, "Filete de ternera", 15, "Filete de vacuno asturiano, sin conservantes", "8.99", "/images/ternera.jpg"));
        repositorioProducto.save(new Producto(10, "Muslos de pollo", 25, "Muslos de pollo de gallina de corral, gran sabor y textura", "6.5", "/images/muslos.jpg"));
        repositorioProducto.save(new Producto(11, "Filetes de pollo", 30, "Filetes de pollo  cortados en finas lonchas, sin conservantes", "5.99", "/images/pollo.jpg"));

        //Frutas y Verduras
        repositorioProducto.save(new Producto(12, "Manzanas Golden", 10, "Pieza de 200gr aprox. ", "1.45", "/images/imgManzanas.jpg"));
        repositorioProducto.save(new Producto(13, "Naranjas de Mesa", 50, "Naranjas de Valencia. Malla de 3 kg. Producto Nacional", "4.15", "/images/imgNaranjas.jpg"));
        repositorioProducto.save(new Producto(14, "Tomates de Rama", 15, "Bandeja de 1 kg aproximado. Ideal para ensaladas.", "3.10", "/images/imgTomate.jpg"));
        repositorioProducto.save(new Producto(15, "Judías Verdes", 15, "Bolsa de medio kilo. Preparadas para cocer.", "2.10", "/images/imgJudias.jpg"));


        //Bebidas
        repositorioProducto.save(new Producto(16, "Agua Mineral Bezoya", 15, "Agua de mineralización débil. 1.5L", "0.99", "/images/imgAgua.jpg"));
        repositorioProducto.save(new Producto(17, "Coca-Cola", 15, "Bebida refrescante gaseosa. Pack de 6 latas.", "2.19", "/images/imgCocaCola.jpg"));
        repositorioProducto.save(new Producto(18, "Fanta Naranja", 15, "Bebida refrescante. Sabor Naranja. Pack de 6 latas.", "1.99", "/images/imgFanta.jpg"));
        repositorioProducto.save(new Producto(19, "Cerveza Peroni", 15, "Cerveza italiana procedente de la región del Lacio. 5.5% alc. ", "4.99", "/images/imgCerveza.jpg"));


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
