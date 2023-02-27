package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.*;


@Controller
public class CatOfertProdController {

    public long prod;
    @Autowired
    private RepositorioOferta repositorioOferta;

    @PostConstruct
    public void init() {

        //Ofertas
        repositorioOferta.save(new Producto(1, "Carne de Res", 10, "Carne de vacuno con altas propiedades proteicas", "12.99", "/images/imgCarneOFERTA.jpg",1));
        repositorioOferta.save(new Producto(2, "Platanos de Canarias", 50, "Platano 100% Canario extraido de las mejores plantaciones", "3.5", "/images/imgPlatanosOFERTA.jpg",1));
        repositorioOferta.save(new Producto(3, "Detergente LimpiaFull", 15, "El mejor detergente para tu ropa, olor suave y agradble", "4.99", "/images/imgDetergenteOFERTA.jpg",1));

        //Panaderia y reposteria
        repositorioOferta.save(new Producto(4, "Donut", 15, "El mejor sabor con la receta original de Donuts", "2.5", "/images/donut.jpg",1));
        repositorioOferta.save(new Producto(5, "Pan", 75, "Pan recien horneado hecho con masa madre", "0.99", "/images/pan.jpg",1));
        repositorioOferta.save(new Producto(6, "Tarta de queso", 10, "Receta original con queso filadelphia y base de galleta María", "12.99", "/images/tarta.jpg",1));
        repositorioOferta.save(new Producto(7, "Croissant", 45, "Croissant hecho a partir de la receta original", "1.99", "/images/croissant.jpg",1));

        //Carnes y Pescados
        repositorioOferta.save(new Producto(8, "Filete de lomo", 20, "Filete de lomo de la mayor calidad, cerdos 100% ibericos", "6.99", "/images/cerdo.jpg",1));
        repositorioOferta.save(new Producto(9, "Filete de ternera", 15, "Filete de vacuno asturiano, sin conservantes", "8.99", "/images/ternera.jpg",1));
        repositorioOferta.save(new Producto(10, "Muslos de pollo", 25, "Muslos de pollo de gallina de corral, gran sabor y textura", "6.5", "/images/muslos.jpg",1));
        repositorioOferta.save(new Producto(11, "Filetes de pollo", 30, "Filetes de pollo  cortados en finas lonchas, sin conservantes", "5.99", "/images/pollo.jpg",1));

        //Frutas y Verduras
        repositorioOferta.save(new Producto(12, "Manzanas Golden", 10, "Pieza de 200gr aprox. ", "1.45", "/images/imgManzanas.jpg",1));
        repositorioOferta.save(new Producto(13, "Naranjas de Mesa", 50, "Naranjas de Valencia. Malla de 3 kg. Producto Nacional", "4.15", "/images/imgNaranjas.jpg",1));
        repositorioOferta.save(new Producto(14, "Tomates de Rama", 15, "Bandeja de 1 kg aproximado. Ideal para ensaladas.", "3.10", "/images/imgTomate.jpg",1));
        repositorioOferta.save(new Producto(15, "Judías Verdes", 15, "Bolsa de medio kilo. Preparadas para cocer.", "2.10", "/images/imgJudias.jpg",1));


        //Bebidas
        repositorioOferta.save(new Producto(16, "Agua Mineral Bezoya", 15, "Agua de mineralización débil. 1.5L", "0.99", "/images/imgAgua.jpg",1));
        repositorioOferta.save(new Producto(17, "Coca-Cola", 15, "Bebida refrescante gaseosa. Pack de 6 latas.", "2.19", "/images/imgCocaCola.jpg",1));
        repositorioOferta.save(new Producto(18, "Fanta Naranja", 15, "Bebida refrescante. Sabor Naranja. Pack de 6 latas.", "1.99", "/images/imgFanta.jpg",1));
        repositorioOferta.save(new Producto(19, "Cerveza Peroni", 15, "Cerveza italiana procedente de la región del Lacio. 5.5% alc. ", "4.99", "/images/imgCerveza.jpg",1));


        //Productos de limpieza
        repositorioOferta.save(new Producto(20, "Cepillo rotador", 10, "Cepillo para limpieza facial", "15.99", "/images/cepilloLimpiezaCara.jpg",1));
        repositorioOferta.save(new Producto(21, "Champú Magic", 50, "Champú especial para deportistas", "3.5", "/images/champuDeportistas.png",1));
        repositorioOferta.save(new Producto(22, "Lociones PielSana", 15, "Lociones especiales para el cuidado de la piel", "20", "/images/locionesPiel.jpg",1));
        repositorioOferta.save(new Producto(23, "Papel Sudoku", 50, "Ppapel higiénico con dibujos de sudoku", "2.35", "/images/papelHigienicoSudoku.jpg",1));

        //Congelados
        repositorioOferta.save(new Producto(24, "Patatas fritas", 10, "Patatas fritas para calentar al horno (1 kg)", "3.60", "/images/patatasFritas.jpg",1));
        repositorioOferta.save(new Producto(25, "Pizza cuatro quesos", 50, "Pizza cuatro quesos calidad gourmet", "6.99", "/images/pizzaCuatroQuesos.jpg",1));
        repositorioOferta.save(new Producto(26, "Alitas barbacoa", 15, "Alitas de pollo con salsa barocoa (12 piezas)", "5.50", "/images/alitasBarbacoa.jpg",1));
        repositorioOferta.save(new Producto(27, "Polos de naranja", 50, "Caja de 12 polos helados sabor naranja", "4.25", "/images/poloHelado.jpg",1));

    }

    public List<Long> ids = new ArrayList<Long>();
    public int cantidad = 1;
    @GetMapping("/producto")
    public String Producto(Model model, @RequestParam long id){

        prod = ids.get((int)id);
        Optional <Producto> productoOptional = repositorioOferta.findById(prod);
        if(productoOptional.isPresent()){
            Producto p = productoOptional.get();
            model.addAttribute("producto",p.getName());
            model.addAttribute("precio", p.getPrecio());
            model.addAttribute("titulo", p.getName());
            model.addAttribute("descripcion", p.getDescripcion());
            model.addAttribute("imagen", p.getImagen());
            model.addAttribute("id", p.getId());
            model.addAttribute("cantidad",cantidad);
        }

        return "producto";
    }



    @GetMapping("/categoria")
    public String Categorias(Model model,String cat, long id1, long id2, long id3, long id4) {

        if(!ids.isEmpty()){
            ids.clear();
        }
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

        if(!ids.isEmpty()){
            ids.clear();
        }

        ids.add((long) 1);
        ids.add((long) 2);
        ids.add((long) 3);

        return "ofertas";
    }

}


