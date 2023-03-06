package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Categoria;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Repositorios.RepositorioCategoria;
import com.example.supermercasa.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.*;


@Controller
public class ProductController {

    public long prod;

    private CategoriasOfertasController categoriasOfertasController;
    @Autowired
    private RepositorioProducto repositorioProducto;

    @Autowired
    private RepositorioCategoria repositorioCategoria;


    Categoria categoria;
    Producto aux;

    @PostConstruct
    public void init() {

        repositorioCategoria.save(new Categoria("Ofertas"));
        repositorioCategoria.save(new Categoria("Panaderia y Reposteria"));
        repositorioCategoria.save(new Categoria("Carnes y Pescados"));
        repositorioCategoria.save(new Categoria("Frutas y Verduras"));
        repositorioCategoria.save(new Categoria("Bebidas"));
        repositorioCategoria.save(new Categoria("Productos de Limpieza"));
        repositorioCategoria.save(new Categoria("Congelados"));


        //Ofertas
        categoria = repositorioCategoria.findByNombre("Ofertas");

        aux = new Producto( "Carne de Res", 10, "Carne de vacuno con altas propiedades proteicas", 12.99, "/images/imgCarneOFERTA.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Platanos de Canarias", 50, "Platano 100% Canario extraido de las mejores plantaciones", 3.5, "/images/imgPlatanosOFERTA.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Detergente LimpiaFull", 15, "El mejor detergente para tu ropa, olor suave y agradble", 4.99, "/images/imgDetergenteOFERTA.jpg", categoria);
        repositorioProducto.save(aux);



        //Panaderia y reposteria
        categoria = repositorioCategoria.findByNombre("Panaderia y Reposteria");

        aux = new Producto("Donut", 15, "El mejor sabor con la receta original de Donuts", 2.5, "/images/donut.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Pan", 75, "Pan recien horneado hecho con masa madre", 0.99, "/images/pan.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Tarta de queso", 10, "Receta original con queso filadelphia y base de galleta María", 12.99, "/images/tarta.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Croissant", 45, "Croissant hecho a partir de la receta original", 1.99, "/images/croissant.jpg", categoria);
        repositorioProducto.save(aux);


        //Carnes y Pescados
        categoria = repositorioCategoria.findByNombre("Carnes y Pescados");

        aux = new Producto("Filete de lomo", 20, "Filete de lomo de la mayor calidad, cerdos 100% ibericos", 6.99, "/images/cerdo.jpg", categoria);
        repositorioProducto.save(aux);


        aux = new Producto("Filete de ternera", 15, "Filete de vacuno asturiano, sin conservantes", 8.99, "/images/ternera.jpg", categoria);
        repositorioProducto.save(aux);


        aux = new Producto("Muslos de pollo", 25, "Muslos de pollo de gallina de corral, gran sabor y textura", 6.5, "/images/muslos.jpg", categoria);
        repositorioProducto.save(aux);


        aux = new Producto("Filetes de pollo", 30, "Filetes de pollo  cortados en finas lonchas, sin conservantes", 5.99, "/images/pollo.jpg", categoria);
        repositorioProducto.save(aux);


        //Frutas y Verduras
        categoria = repositorioCategoria.findByNombre("Frutas y Verduras");

        aux = new Producto("Manzanas Golden", 10, "Pieza de 200gr aprox. ", 1.45, "/images/imgManzanas.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Naranjas de Mesa", 50, "Naranjas de Valencia. Malla de 3 kg. Producto Nacional", 4.15, "/images/imgNaranjas.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Tomates de Rama", 15, "Bandeja de 1 kg aproximado. Ideal para ensaladas.", 3.10, "/images/imgTomate.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Judías Verdes", 15, "Bolsa de medio kilo. Preparadas para cocer.", 2.10, "/images/imgJudias.jpg", categoria);
        repositorioProducto.save(aux);


        //Bebidas
        categoria = repositorioCategoria.findByNombre("Bebidas");

        aux = new Producto("Agua Mineral Bezoya", 15, "Agua de mineralización débil. 1.5L", 0.99, "/images/imgAgua.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Coca-Cola", 15, "Bebida refrescante gaseosa. Pack de 6 latas.", 2.19, "/images/imgCocaCola.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Fanta Naranja", 15, "Bebida refrescante. Sabor Naranja. Pack de 6 latas.", 1.99, "/images/imgFanta.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Cerveza Peroni", 15, "Cerveza italiana procedente de la región del Lacio. 5.5% alc. ", 4.99, "/images/imgCerveza.jpg", categoria);
        repositorioProducto.save(aux);


        //Productos de limpieza
        categoria = repositorioCategoria.findByNombre("Productos de Limpieza");

        aux = new Producto("Cepillo rotador", 10, "Cepillo para limpieza facial", 15.99, "/images/cepilloLimpiezaCara.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Champú Magic", 50, "Champú especial para deportistas", 3.5, "/images/champuDeportistas.png", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Lociones PielSana", 15, "Lociones especiales para el cuidado de la piel", 20, "/images/locionesPiel.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Papel Sudoku", 50, "Ppapel higiénico con dibujos de sudoku", 2.35, "/images/papelHigienicoSudoku.jpg", categoria);
        repositorioProducto.save(aux);


        //Congelados
        categoria = repositorioCategoria.findByNombre("Congelados");

        aux = new Producto("Patatas fritas", 10, "Patatas fritas para calentar al horno (1 kg)", 3.6, "/images/patatasFritas.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Pizza cuatro quesos", 50, "Pizza cuatro quesos calidad gourmet", 6.99, "/images/pizzaCuatroQuesos.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Alitas barbacoa", 15, "Alitas de pollo con salsa barocoa (12 piezas)", 5.5, "/images/alitasBarbacoa.jpg", categoria);
        repositorioProducto.save(aux);

        aux = new Producto("Polos de naranja", 50, "Caja de 12 polos helados sabor naranja", 4.25, "/images/poloHelado.jpg", categoria);
        repositorioProducto.save(aux);

    }

    @GetMapping("/producto/{id}")
    public String Producto(Model model, @PathVariable long id){

        Optional <Producto> productoOptional = repositorioProducto.findById(id);
        if(productoOptional.isPresent()){
            Producto p = productoOptional.get();
            model.addAttribute("nombre",p.getName());
            model.addAttribute("precio", p.getPrecio());
            model.addAttribute("titulo", p.getName());
            model.addAttribute("descripcion", p.getDescripcion());
            model.addAttribute("imagen", p.getImagen());
            model.addAttribute("id", p.getId());
            model.addAttribute("stock", "");

        }

        return "producto";
    }

    @GetMapping("/nuevoProducto")
    public String nuevoProducto(Model model, @RequestParam String nameProd, @RequestParam String description,
                                @RequestParam String price, @RequestParam int nstock, @RequestParam String categories){

        if(repositorioProducto.getProductoByName(nameProd) == null){
            //el producto no existe, por lo que se puede crear
            aux = new Producto(nameProd, nstock, description, Double.parseDouble(price), "/images/imagenPorDefecto.jpg", repositorioCategoria.findByNombre(categories));
            repositorioProducto.save(aux);
            repositorioCategoria.findByNombre(categories).addProductos(aux);
            model.addAttribute("mensajeAddProd", "Producto añadido con éxito");
        }else{
            //el producto existe, por lo que no se puede crear
            model.addAttribute("mensajeAddProd", "Producto ya existente en la base de datos");
        }

        model.addAttribute("mensajeEliminar", "");
        model.addAttribute("mensajeModificar", "");
        return "administrarProductos";
    }

    @GetMapping("/eliminarProducto")
    public String eliminarProducto(Model model, @RequestParam String prodName){

        Producto prod = repositorioProducto.getProductoByName(prodName);

        if(prod == null){
            model.addAttribute("mensajeEliminar", "El producto no existe");
        }else{
            for(Categoria categorias : prod.getCategorias()){
                categorias.getProductos().remove(prod);
                repositorioCategoria.save(categorias);
            }
            prod.getCategorias().clear();
            repositorioProducto.delete(prod);
            model.addAttribute("mensajeEliminar", "El producto ha sido eliminado con éxito");
        }

        model.addAttribute("mensajeAddProd", "");
        model.addAttribute("mensajeModificar", "");
        return "administrarProductos";
    }

    @GetMapping("/modificarProducto")
    public String modificarProducto(Model model, @RequestParam String productoAModificar, @RequestParam String nameProducto,
                                    @RequestParam String descriptionProd, @RequestParam String priceProd, @RequestParam int stockProd,
                                    @RequestParam String categoriesProd){

        Producto prodAModificar = repositorioProducto.getProductoByName(productoAModificar);
        if(prodAModificar == null){
            model.addAttribute("mensajeModificar", "El producto buscado no existe");
        }else{
            if(nameProducto != ""){
                prodAModificar.setName(nameProducto);
            }else{
                prodAModificar.setName(prodAModificar.getName());
            }
            if(descriptionProd != ""){
                prodAModificar.setDescripcion(descriptionProd);
            }else{
                prodAModificar.setDescripcion(prodAModificar.getDescripcion());
            }
            if(priceProd != ""){
                prodAModificar.setPrecio(Double.parseDouble(priceProd));
            }else{
                prodAModificar.setPrecio(prodAModificar.getPrecio());
            }
            if(stockProd != 0){
                prodAModificar.setStock(stockProd);
            }else{
                prodAModificar.setStock(prodAModificar.getStock());
            }
            if(categoriesProd != null){
                prodAModificar.addCategoria(repositorioCategoria.findByNombre(categoriesProd));;
            }else{
                prodAModificar.setCategorias(prodAModificar.getCategorias());
            }
            repositorioProducto.save(prodAModificar);
            model.addAttribute("mensajeModificar", "Elemento modificado de forma correcta");
        }

        model.addAttribute("mensajeAddProd", "");
        model.addAttribute("mensajeEliminar", "");
        return "administrarProductos";
    }

    @GetMapping("/administrarProductos")
    public String administrarProductos(Model model){
        model.addAttribute("mensajeAddProd", "");
        model.addAttribute("mensajeEliminar", "");
        model.addAttribute("mensajeModificar", "");

        return "administrarProductos";
    }

}


