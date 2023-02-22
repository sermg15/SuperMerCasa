package com.example.supermercasa.Controllers;

import com.example.supermercasa.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLogSignController {

    @Autowired
    public RepositorioUsuario repositorioUsuario;
    public int users_id=0;
    @GetMapping("/perfilusuario")
    public String PerfilUsuario(Model model){

        if(repositorioUsuario.findById(users_id).isPresent()){
            model.addAttribute("Nombre Usuario",repositorioUsuario .findById(users_id).get().getNombreUsuario());
            model.addAttribute("Contraseña", repositorioUsuario.findById(users_id).get().getContraseña());
            model.addAttribute("mail", repositorioUsuario.findById(users_id).get().getEmail());
            model.addAttribute("Direccion", repositorioUsuario.findById(users_id).get().getDirecction());
        }
        return "perfilUsuario";
    }

    @GetMapping("/registroLogin")
    public String RegistroLogin(Model model){



        return "registroLogin";
    }
}
