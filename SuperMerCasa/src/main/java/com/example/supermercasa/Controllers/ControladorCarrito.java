package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Entidades.Pedido;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import com.example.supermercasa.Repositorios.RepositorioCarrito;
import com.example.supermercasa.Repositorios.RepositorioProducto;
import com.example.supermercasa.Repositorios.RepositorioPedido;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import com.example.supermercasa.ServicioInterno.servInternoMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

@Controller
public class ControladorCarrito {

    @Autowired
    private RepositorioProducto repositorioProducto;
    @Autowired
    private RepositorioCarrito repositorioCarrito;
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioPedido repositorioPedido;

    Carrito carrito;
    Producto producto;
    Pedido pedido;


    @GetMapping("/carrito")
    public String Carrito(Model model, @RequestParam String comprado, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user = repositorioUsuario.findByNombreUsuario(principal.getName());

        carrito = repositorioCarrito.findByUser(user.get());

        if(carrito == null){

            model.addAttribute("productos", null);
            model.addAttribute("precios", null);
            model.addAttribute("cantidad", "");
            model.addAttribute("precioTotal", "0");
            model.addAttribute("comprado", "");
        }else{

            model.addAttribute("productos", carrito.getListaProductos());
            model.addAttribute("precios", carrito.getListaProductos());
            model.addAttribute("cantidad", carrito.getCantidadProductos());
            model.addAttribute("precioTotal", precioTotal);
            model.addAttribute("comprado", comprado);
        }

        return "carrito";
    }

    double precioTotal;

    @GetMapping("/addProducto/{id}")
    public String addProducto(Model model, @PathVariable long id, @RequestParam int cantidad, HttpServletRequest request){

        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user = repositorioUsuario.findByNombreUsuario(principal.getName());

        producto = repositorioProducto.findById(id).get();
        carrito = repositorioCarrito.findByUser(user.get());

        if(carrito == null){

            precioTotal = 0;

            if(producto.getStock() >= cantidad){
                repositorioCarrito.save(new Carrito(user.get(),producto, cantidad));
                producto.subStock(cantidad);
                repositorioProducto.flush();
                carrito = repositorioCarrito.findByUser(user.get());

                precioTotal = producto.getPrecio() * cantidad;
                precioTotal = (double)Math.round(precioTotal * 100) / 100;

                model.addAttribute("productos", carrito.getListaProductos());
                model.addAttribute("precios", carrito.getListaProductos());
                model.addAttribute("cantidad", carrito.getCantidadProductos());
                model.addAttribute("precioTotal", precioTotal);
                model.addAttribute("comprado", "");

            }else{

                model.addAttribute("nombre",producto.getName());
                model.addAttribute("precio", producto.getPrecio());
                model.addAttribute("titulo", producto.getName());
                model.addAttribute("descripcion", producto.getDescripcion());
                model.addAttribute("imagen", producto.getImagen());
                model.addAttribute("id", producto.getId());

                return "producto";
            }
        }
       else{

           if(producto.getStock() >= cantidad){

               if(carrito.getListaProductos().contains(producto)){
                   producto.subStock(cantidad);
                   repositorioProducto.flush();
                   carrito.addCantidades(cantidad, carrito.getListaProductos().indexOf(producto));
                   repositorioCarrito.flush();

                   precioTotal += producto.getPrecio() * cantidad;
                   precioTotal = (double)Math.round(precioTotal * 100) / 100;

                   model.addAttribute("productos", carrito.getListaProductos());
                   model.addAttribute("precios", carrito.getListaProductos());
                   model.addAttribute("cantidad", carrito.getCantidadProductos());
                   model.addAttribute("precioTotal", precioTotal);
                   model.addAttribute("comprado", "");

               }else{

                   repositorioCarrito.findByUser(user.get()).aniadirProducto(producto, cantidad);
                   producto.subStock(cantidad);
                   repositorioProducto.flush();
                   repositorioCarrito.flush();

                   carrito = repositorioCarrito.findByUser(user.get());

                   precioTotal += producto.getPrecio() * cantidad;
                   precioTotal = (double)Math.round(precioTotal * 100) / 100;

                   model.addAttribute("productos", carrito.getListaProductos());
                   model.addAttribute("precios", carrito.getListaProductos());
                   model.addAttribute("cantidad", carrito.getCantidadProductos());
                   model.addAttribute("precioTotal", precioTotal);
                   model.addAttribute("comprado", "");
               }

           }else{

               model.addAttribute("nombre",producto.getName());
               model.addAttribute("precio", producto.getPrecio());
               model.addAttribute("titulo", producto.getName());
               model.addAttribute("descripcion", producto.getDescripcion());
               model.addAttribute("imagen", producto.getImagen());
               model.addAttribute("id", producto.getId());
               model.addAttribute("stock", "NO HAY STOCK SUFICIENTE PARA ESE PRODUCTO, LA CANTIDAD MAXIMA POSIBLE ES DE: " +  producto.getStock() + " UNIDADES");

               return "producto";
           }

       }
        return "carrito";
    }

    @GetMapping("/addSeguimiento")
    public String addSeguimiento(Model model, @RequestParam String comprado, HttpServletRequest request){

        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user = repositorioUsuario.findByNombreUsuario(principal.getName());

        carrito = repositorioCarrito.findByUser(user.get());


        if(carrito == null){

            model.addAttribute("productos", null);
            model.addAttribute("precios",null);
            model.addAttribute("cantidad", "");
            model.addAttribute("precioTotal", "0");
            model.addAttribute("comprado", "NO HAY PRODUCTOS SUFICIENTES PARA REALIZAR UN PEDIDO");

        }else{

            Pedido pedido = new Pedido(carrito.getListaProductos(), user.get(),"Recibido",precioTotal, carrito.getCantidadProductos());
            user.get().addPedidos(repositorioPedido.save(pedido));

            if(servInternoMail.sendPedidoEmail(user.get(),pedido)){
                model.addAttribute("productos", null);
                model.addAttribute("precios",null);
                model.addAttribute("cantidad", "");
                model.addAttribute("precioTotal", "0");
                model.addAttribute("comprado", comprado);
            }else{
                model.addAttribute("productos", null);
                model.addAttribute("precios",null);
                model.addAttribute("cantidad", "");
                model.addAttribute("precioTotal", "0");
                model.addAttribute("comprado", "ERROR AL CONFIRMAR TU PEDIDO");
            }




            repositorioCarrito.deleteById(carrito.getId());

        }

        return "carrito";
    }
}
