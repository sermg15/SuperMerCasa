package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPerfil {
    @GetMapping("/perfilusuario")
    public String PerfilUsuario(Model model){

        model.addAttribute("name", "Sergio");
        model.addAttribute("email", "sergio@gmail.com");
        model.addAttribute("direction", "Calle Ejemplo, s/n");
        return "perfilUsuario";
    }
}
