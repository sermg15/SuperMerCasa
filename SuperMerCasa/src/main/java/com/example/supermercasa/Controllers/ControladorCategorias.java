package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControladorCategorias {
    @GetMapping("/categoria")
    public String Categorias(Model model) {

        model.addAttribute("categoría", "(Nombre de la categoría)");

        model.addAttribute("producto1", "(imagen)");
        model.addAttribute("producto2", "(imagen)");
        model.addAttribute("producto3", "(imagen)");
        model.addAttribute("producto4", "(imagen)");

        model.addAttribute("nombre1", "(producto a)");
        model.addAttribute("nombre2", "(producto b)");
        model.addAttribute("nombre3", "(producto c)");
        model.addAttribute("nombre4", "(producto d)");

        model.addAttribute("precio1", "(precio)");
        model.addAttribute("precio2", "(precio)");
        model.addAttribute("precio3", "(precio)");
        model.addAttribute("precio4", "(precio)");

        return "categorias";
    }
}
