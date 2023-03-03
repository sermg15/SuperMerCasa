package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Categoria;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.RepositorioCategoria;
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

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    private String catOfertas = "Ofertas";
    private String catPanaderia = "Panaderia y reposteria";
    private String catCarne = "Carne y pescado";
    private String catFrutas = "Fruta y verdura";
    private String catBebidas = "Bebidas";
    private String catLimpieza = "Productos de limpieza";
    private String catConelados = "Congelados";

    Categoria ofertas = new Categoria(catOfertas);
    Categoria panaderia = new Categoria(catPanaderia);
    Categoria carne = new Categoria(catCarne);
    Categoria frutas = new Categoria(catFrutas);
    Categoria bebidas = new Categoria(catBebidas);
    Categoria limpieza = new Categoria(catLimpieza);
    Categoria congelados = new Categoria(catConelados);



    @PostConstruct
    public void init() {

        repositorioCategoria.save(ofertas);
        repositorioCategoria.save(panaderia);
        repositorioCategoria.save(carne);
        repositorioCategoria.save(frutas);
        repositorioCategoria.save(bebidas);
        repositorioCategoria.save(limpieza);
        repositorioCategoria.save(congelados);

        Producto aux;

        //Ofertas
        aux = new Producto(1, "Carne de Res", 10, "Carne de vacuno con altas propiedades proteicas", 12.99, "/images/imgCarneOFERTA.jpg");
        repositorioOferta.save(aux);
        ofertas.getProductos().add(aux);

        aux = new Producto(2, "Platanos de Canarias", 50, "Platano 100% Canario extraido de las mejores plantaciones", 3.5, "/images/imgPlatanosOFERTA.jpg");
        repositorioOferta.save(aux);
        ofertas.getProductos().add(aux);

        aux = new Producto(3, "Detergente LimpiaFull", 15, "El mejor detergente para tu ropa, olor suave y agradble", 4.99, "/images/imgDetergenteOFERTA.jpg");
        repositorioOferta.save(aux);
        ofertas.getProductos().add(aux);
        //ofertas.addProducto(aux);


        //Panaderia y reposteria
        aux = new Producto(4, "Donut", 15, "El mejor sabor con la receta original de Donuts", 2.5, "/images/donut.jpg");
        repositorioOferta.save(aux);
        panaderia.addProducto(aux);
        aux.addCategoria(panaderia);

        aux = new Producto(5, "Pan", 75, "Pan recien horneado hecho con masa madre", 0.99, "/images/pan.jpg");
        repositorioOferta.save(aux);
        panaderia.addProducto(aux);
        aux.addCategoria(panaderia);

        aux = new Producto(6, "Tarta de queso", 10, "Receta original con queso filadelphia y base de galleta María", 12.99, "/images/tarta.jpg");
        repositorioOferta.save(aux);
        panaderia.addProducto(aux);
        aux.addCategoria(panaderia);
        aux = new Producto(7, "Croissant", 45, "Croissant hecho a partir de la receta original", 1.99, "/images/croissant.jpg");
        repositorioOferta.save(aux);
        panaderia.addProducto(aux);
        aux.addCategoria(panaderia);

        //Carnes y Pescados
        aux = new Producto(8, "Filete de lomo", 20, "Filete de lomo de la mayor calidad, cerdos 100% ibericos", 6.99, "/images/cerdo.jpg");
        repositorioOferta.save(aux);
        carne.addProducto(aux);
        aux.addCategoria(carne);

        aux = new Producto(9, "Filete de ternera", 15, "Filete de vacuno asturiano, sin conservantes", 8.99, "/images/ternera.jpg");
        repositorioOferta.save(aux);
        carne.addProducto(aux);
        aux.addCategoria(carne);
        aux = new Producto(10, "Muslos de pollo", 25, "Muslos de pollo de gallina de corral, gran sabor y textura", 6.5, "/images/muslos.jpg");
        repositorioOferta.save(aux);
        carne.addProducto(aux);
        aux.addCategoria(carne);
        aux = new Producto(11, "Filetes de pollo", 30, "Filetes de pollo  cortados en finas lonchas, sin conservantes", 5.99, "/images/pollo.jpg");
        repositorioOferta.save(aux);
        carne.addProducto(aux);
        aux.addCategoria(carne);

        repositorioCategoria.save(carne);

        //Frutas y Verduras
        aux = new Producto(12, "Manzanas Golden", 10, "Pieza de 200gr aprox. ", 1.45, "/images/imgManzanas.jpg");
        repositorioOferta.save(aux);
        frutas.addProducto(aux);
        aux.addCategoria(frutas);
        aux = new Producto(13, "Naranjas de Mesa", 50, "Naranjas de Valencia. Malla de 3 kg. Producto Nacional", 4.15, "/images/imgNaranjas.jpg");
        repositorioOferta.save(aux);
        frutas.addProducto(aux);
        aux.addCategoria(frutas);
        aux = new Producto(14, "Tomates de Rama", 15, "Bandeja de 1 kg aproximado. Ideal para ensaladas.", 3.10, "/images/imgTomate.jpg");
        repositorioOferta.save(aux);
        frutas.addProducto(aux);
        aux.addCategoria(frutas);
        aux = new Producto(15, "Judías Verdes", 15, "Bolsa de medio kilo. Preparadas para cocer.", 2.10, "/images/imgJudias.jpg");
        repositorioOferta.save(aux);
        frutas.addProducto(aux);
        aux.addCategoria(frutas);


        //Bebidas
        aux = new Producto(16, "Agua Mineral Bezoya", 15, "Agua de mineralización débil. 1.5L", 0.99, "/images/imgAgua.jpg");
        repositorioOferta.save(aux);
        bebidas.addProducto(aux);
        aux.addCategoria(bebidas);
        aux = new Producto(17, "Coca-Cola", 15, "Bebida refrescante gaseosa. Pack de 6 latas.", 2.19, "/images/imgCocaCola.jpg");
        repositorioOferta.save(aux);
        bebidas.addProducto(aux);
        aux.addCategoria(bebidas);
        aux = new Producto(18, "Fanta Naranja", 15, "Bebida refrescante. Sabor Naranja. Pack de 6 latas.", 1.99, "/images/imgFanta.jpg");
        repositorioOferta.save(aux);
        bebidas.addProducto(aux);
        aux.addCategoria(bebidas);
        aux = new Producto(19, "Cerveza Peroni", 15, "Cerveza italiana procedente de la región del Lacio. 5.5% alc. ", 4.99, "/images/imgCerveza.jpg");
        repositorioOferta.save(aux);
        bebidas.addProducto(aux);
        aux.addCategoria(bebidas);


        //Productos de limpieza
        aux = new Producto(20, "Cepillo rotador", 10, "Cepillo para limpieza facial", 15.99, "/images/cepilloLimpiezaCara.jpg");
        repositorioOferta.save(aux);
        limpieza.addProducto(aux);
        aux.addCategoria(limpieza);
        aux = new Producto(21, "Champú Magic", 50, "Champú especial para deportistas", 3.5, "/images/champuDeportistas.png");
        repositorioOferta.save(aux);
        limpieza.addProducto(aux);
        aux.addCategoria(limpieza);
        aux = new Producto(22, "Lociones PielSana", 15, "Lociones especiales para el cuidado de la piel", 20, "/images/locionesPiel.jpg");
        repositorioOferta.save(aux);
        limpieza.addProducto(aux);
        aux.addCategoria(limpieza);
        aux = new Producto(23, "Papel Sudoku", 50, "Ppapel higiénico con dibujos de sudoku", 2.35, "/images/papelHigienicoSudoku.jpg");
        repositorioOferta.save(aux);
        limpieza.addProducto(aux);
        aux.addCategoria(limpieza);

        //Congelados
        aux = new Producto(24, "Patatas fritas", 10, "Patatas fritas para calentar al horno (1 kg)", 3.6, "/images/patatasFritas.jpg");
        repositorioOferta.save(aux);
        congelados.addProducto(aux);
        aux.addCategoria(congelados);
        aux = new Producto(25, "Pizza cuatro quesos", 50, "Pizza cuatro quesos calidad gourmet", 6.99, "/images/pizzaCuatroQuesos.jpg");
        repositorioOferta.save(aux);
        congelados.addProducto(aux);
        aux.addCategoria(congelados);
        aux = new Producto(26, "Alitas barbacoa", 15, "Alitas de pollo con salsa barocoa (12 piezas)", 5.5, "/images/alitasBarbacoa.jpg");
        repositorioOferta.save(aux);
        congelados.addProducto(aux);
        aux.addCategoria(congelados);
        aux = new Producto(27, "Polos de naranja", 50, "Caja de 12 polos helados sabor naranja", 4.25, "/images/poloHelado.jpg");
        repositorioOferta.save(aux);
        congelados.addProducto(aux);
        aux.addCategoria(congelados);



    }

    public List<Long> ids = new ArrayList<Long>();

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
        }

        return "producto";
    }



    @GetMapping("/categoria")
    public String Categorias(Model model,String cat) {

        model.addAttribute("categoria", cat);

        if(!repositorioCategoria.findByNombre(cat).getProductos().isEmpty()){
            List<Producto> productos = repositorioOferta.findByCategoriasNombre(cat);
            model.addAttribute("productos", productos);
            model.addAttribute("mensajeBucle", "if");
        }else{
            model.addAttribute("mensajeBucle", "else");
        }

        return "categorias";
    }

    @GetMapping("/ofertas")
    public String ofertas(Model model){

        if(repositorioCategoria.findByNombre("Ofertas") != null){
            List<Producto> productos = repositorioCategoria.findByNombre("Ofertas").getProductos();
            model.addAttribute("productos", productos);
        }

        return "ofertas";
    }

}


