package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorProducto {

    @GetMapping("/ofertas/producto")
    public String Producto(Model model, @RequestParam String Precio, @RequestParam String tipo){


        model.addAttribute("producto", tipo);
        model.addAttribute("precio", Precio);
        model.addAttribute("titulo", tipo);


        return "producto";
    }
}
