package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControladorCarrito {
    @GetMapping("/carrito")
    public String Carrito(Model model) {

        model.addAttribute("producto1", "Pollo");
        model.addAttribute("producto2", "Arroz");
        model.addAttribute("producto3", "Huevos");

        model.addAttribute("cantidad1", "2 kg");
        model.addAttribute("cantidad2", "3 kg");
        model.addAttribute("cantidad3", "2 docenas");

        model.addAttribute("precio1", "8,99 /kg");
        model.addAttribute("precio2", "3,50/kg");
        model.addAttribute("precio3", "10 /docena");

        model.addAttribute("suma", "48,30" );

        return "carrito";
    }
}
