package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.*;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class UserLogSignController {

    @Autowired
    public RepositorioUsuario repositorioUsuario;
    public long users_id=0;

    @PostConstruct
    public void init(){
        repositorioUsuario.save(new Usuario((long) 0, "Sergio", "sergio@ejemplo.es", "Calle Ejemplo, 3", "1234"));
    }

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

    int numusuarios = 1;
    @GetMapping("/registroLogin1")
    public String RegistroLogin(Model model, @RequestParam String registername, @RequestParam String registerpassword, @RequestParam String email, @RequestParam String direction){


        if (!repositorioUsuario.findById(users_id).isPresent()){
            repositorioUsuario.save(new Usuario(numusuarios,registername, email, direction, registerpassword));
            numusuarios++;
            model.addAttribute("mensaje", "USUARIO REGISTRADO DE FORMA CORRECTA");
        }else{
            model.addAttribute("mensaje", "USUARIO YA REGISTRADO");
        }

        return "registroLogin";
    }

    @GetMapping ("/registroLogin")
    public String RegistroLogin(Model model){
        model.addAttribute("mensaje", "");

        return "registroLogin";
    }


}
