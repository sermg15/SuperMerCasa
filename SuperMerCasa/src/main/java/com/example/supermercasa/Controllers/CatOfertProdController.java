package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
public class CatOfertProdController {


    @Autowired
    private RepositorioOferta repositorioOferta;

    @PostConstruct
    public void init() {

        //Ofertas
        repositorioOferta.save(new Producto(1, "Carne de Res", 10, "Carne de vacuno con altas propiedades proteicas", "12.99", "/images/imgCarneOFERTA.jpg"));
        repositorioOferta.save(new Producto(2, "Platanos de Canarias", 50, "Platano 100% Canario extraido de las mejores plantaciones", "3.5", "/images/imgPlatanosOFERTA.jpg"));
        repositorioOferta.save(new Producto(3, "Detergente LimpiaFull", 15, "El mejor detergente para tu ropa, olor suave y agradble", "4.99", "/images/imgDetergenteOFERTA.jpg"));

        //Panaderia y reposteria
        repositorioOferta.save(new Producto(4, "Donut", 15, "El mejor sabor con la receta original de Donuts", "2.5", "/images/donut.jpg"));
        repositorioOferta.save(new Producto(5, "Pan", 75, "Pan recien horneado hecho con masa madre", "0.99", "/images/pan.jpg"));
        repositorioOferta.save(new Producto(6, "Tarta de queso", 10, "Receta original con queso filadelphia y base de galleta María", "12.99", "/images/tarta.jpg"));
        repositorioOferta.save(new Producto(7, "Croissant", 45, "Croissant hecho a partir de la receta original", "1.99", "/images/croissant.jpg"));

        //Carnes y Pescados
        repositorioOferta.save(new Producto(8, "Filete de lomo", 20, "Filete de lomo de la mayor calidad, cerdos 100% ibericos", "6.99", "/images/cerdo.jpg"));
        repositorioOferta.save(new Producto(9, "Filete de ternera", 15, "Filete de vacuno asturiano, sin conservantes", "8.99", "/images/ternera.jpg"));
        repositorioOferta.save(new Producto(10, "Muslos de pollo", 25, "Muslos de pollo de gallina de corral, gran sabor y textura", "6.5", "/images/muslos.jpg"));
        repositorioOferta.save(new Producto(11, "Filetes de pollo", 30, "Filetes de pollo  cortados en finas lonchas, sin conservantes", "5.99", "/images/pollo.jpg"));

        //Frutas y Verduras
        repositorioOferta.save(new Producto(12, "Manzanas Golden", 10, "Pieza de 200gr aprox. ", "1.45", "/images/imgManzanas.jpg"));
        repositorioOferta.save(new Producto(13, "Naranjas de Mesa", 50, "Naranjas de Valencia. Malla de 3 kg. Producto Nacional", "4.15", "/images/imgNaranjas.jpg"));
        repositorioOferta.save(new Producto(14, "Tomates de Rama", 15, "Bandeja de 1 kg aproximado. Ideal para ensaladas.", "3.10", "/images/imgTomate.jpg"));
        repositorioOferta.save(new Producto(15, "Judías Verdes", 15, "Bolsa de medio kilo. Preparadas para cocer.", "2.10", "/images/imgJudias.jpg"));


        //Bebidas
        repositorioOferta.save(new Producto(16, "Agua Mineral Bezoya", 15, "Agua de mineralización débil. 1.5L", "0.99", "/images/imgAgua.jpg"));
        repositorioOferta.save(new Producto(17, "Coca-Cola", 15, "Bebida refrescante gaseosa. Pack de 6 latas.", "2.19", "/images/imgCocaCola.jpg"));
        repositorioOferta.save(new Producto(18, "Fanta Naranja", 15, "Bebida refrescante. Sabor Naranja. Pack de 6 latas.", "1.99", "/images/imgFanta.jpg"));
        repositorioOferta.save(new Producto(19, "Cerveza Peroni", 15, "Cerveza italiana procedente de la región del Lacio. 5.5% alc. ", "4.99", "/images/imgCerveza.jpg"));


        //Productos de limpieza
        repositorioOferta.save(new Producto(20, "Cepillo rotador", 10, "Cepillo para limpieza facial", "15.99", "/images/cepilloLimpiezaCara.jpg"));
        repositorioOferta.save(new Producto(21, "Champú Magic", 50, "Champú especial para deportistas", "3.5", "/images/champuDeportistas.png"));
        repositorioOferta.save(new Producto(22, "Lociones PielSana", 15, "Lociones especiales para el cuidado de la piel", "20", "/images/locionesPiel.jpg"));
        repositorioOferta.save(new Producto(23, "Papel Sudoku", 50, "Ppapel higiénico con dibujos de sudoku", "2.35", "/images/papelHigienicoSudoku.jpg"));

        //Congelados
        repositorioOferta.save(new Producto(24, "Patatas fritas", 10, "Patatas fritas para calentar al horno (1 kg)", "3.60", "/images/patatasFritas.jpg"));
        repositorioOferta.save(new Producto(25, "Pizza cuatro quesos", 50, "Pizza cuatro quesos calidad gourmet", "6.99", "/images/pizzaCuatroQuesos.jpg"));
        repositorioOferta.save(new Producto(26, "Alitas barbacoa", 15, "Alitas de pollo con salsa barocoa (12 piezas)", "5.50", "/images/alitasBarbacoa.jpg"));
        repositorioOferta.save(new Producto(27, "Polos de naranja", 50, "Caja de 12 polos helados sabor naranja", "4.25", "/images/poloHelado.jpg"));

    }

    public List<Long> ids;

    @GetMapping("/producto")
    public String Producto(Model model, @RequestParam long id){


        if(repositorioOferta.findById(id).isPresent()){
            model.addAttribute("producto",repositorioOferta .findById(id).get().getName());
            model.addAttribute("precio", repositorioOferta.findById(id).get().getPrecio());
            model.addAttribute("titulo", repositorioOferta.findById(id).get().getName());
            model.addAttribute("descripcion", repositorioOferta.findById(id).get().getDescripcion());
            model.addAttribute("imagen", repositorioOferta.findById(id).get().getImagen());
        }




        return "producto";
    }





    @GetMapping("/categoria")
    public String Categorias(Model model,String cat, long id1, long id2, long id3, long id4) {

        model.addAttribute("categoria", cat);


        if(repositorioOferta.findById(id1).isPresent()){
            model.addAttribute("producto1",repositorioOferta.findById(id1).get().getImagen());
            model.addAttribute("nombre1", repositorioOferta.findById(id1).get().getName());
            model.addAttribute("precio1", repositorioOferta.findById(id1).get().getPrecio());
        }

        if(repositorioOferta.findById(id2).isPresent()){
            model.addAttribute("producto2",repositorioOferta.findById(id2).get().getImagen());
            model.addAttribute("nombre2", repositorioOferta.findById(id2).get().getName());
            model.addAttribute("precio2", repositorioOferta.findById(id2).get().getPrecio());
        }

        if(repositorioOferta.findById(id3).isPresent()){
            model.addAttribute("producto3",repositorioOferta.findById(id3).get().getImagen());
            model.addAttribute("nombre3", repositorioOferta.findById(id3).get().getName());
            model.addAttribute("precio3", repositorioOferta.findById(id3).get().getPrecio());
        }

        if(repositorioOferta.findById(id4).isPresent()){
            model.addAttribute("producto4",repositorioOferta.findById(id4).get().getImagen());
            model.addAttribute("nombre4", repositorioOferta.findById(id4).get().getName());
            model.addAttribute("precio4", repositorioOferta.findById(id4).get().getPrecio());
        }

        ids.add(id1);
        ids.add(id2);
        ids.add(id3);
        ids.add(id4);


        return "categorias";
    }


    @GetMapping("/ofertas")
    public String ofertas(Model model){



        return "ofertas";
    }

}


