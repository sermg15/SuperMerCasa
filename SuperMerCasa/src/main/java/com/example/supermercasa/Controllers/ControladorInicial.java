package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import com.example.supermercasa.Repositorios.RepositorioCategoria;
import com.example.supermercasa.Repositorios.RepositorioProducto;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ControladorInicial {

    private boolean firsTime = true;
    @Autowired
    private RepositorioProducto repositorioProducto;
    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user;

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


        model.addAttribute("logged",false);
        model.addAttribute("admin",false);


        if(principal!=null){
            user = repositorioUsuario.findByNombreUsuario(principal.getName());
            System.out.println("----------------------------------------------------------" + principal.getName());
            model.addAttribute("logged",true);
            for(int i =0; i<user.get().getRoles().size();i++){
                System.out.println("------------------------------------------------------"+user.get().getRoles().get(i)+"---------------"+i);
                if(user.get().getRoles().get(i).equals("ADMIN")){
                    model.addAttribute("admin",true);
                    System.out.println("--------------------------------------------if"+user.get().getRoles().get(i));
                }
            }
        }

        return "inicio";
    }
}
