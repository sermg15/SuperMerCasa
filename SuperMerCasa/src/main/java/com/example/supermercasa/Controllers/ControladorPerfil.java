package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPerfil {
    @GetMapping("/perfilusuario")
    public String PerfilUsuario(Model model, @RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String direction){

        //Usuario user = request.getUser();

        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("email", email);
        model.addAttribute("direction", direction);

        return "perfilUsuario";
    }
}
