package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPerfil {
    @GetMapping("/perfilusuario")
    public String PerfilUsuario(Model model){

        //Usuario user = request.getUser();

        model.addAttribute("name", "Sergio");
        model.addAttribute("surname", "Martinez");
        model.addAttribute("email", "sergio@ejemplo.com");
        model.addAttribute("direction", "Calle Ejemplo, 3");

        return "perfilUsuario";
    }
}
