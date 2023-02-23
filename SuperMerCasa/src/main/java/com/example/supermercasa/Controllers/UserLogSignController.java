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
    public long users_id;

    public long getId(){
        return users_id;
    }
    @PostConstruct
    public void init(){
        repositorioUsuario.save(new Usuario( 1, "Sergio", "sergio@ejemplo.es", "Calle Ejemplo, 3", "1234"));
    }

    @GetMapping("/perfilusuario")
    public String PerfilUsuario(Model model){

        if(repositorioUsuario.findById(users_id).isPresent()){
            model.addAttribute("mensaje", "");
            model.addAttribute("name", repositorioUsuario.findById(users_id).get().getNombreUsuario());
            model.addAttribute("email", repositorioUsuario.findById(users_id).get().getEmail());
            model.addAttribute("direction", repositorioUsuario.findById(users_id).get().getDirecction());
        }else{
            model.addAttribute("mensaje", "NO HAY NINGUN USUARIO LOGUEADO");
            model.addAttribute("name", "");
            model.addAttribute("email", "");
            model.addAttribute("direction", "");
        }
        return "perfilUsuario";
    }

    @GetMapping("/login")
    public String RegistroLogin(Model model, @RequestParam String username, @RequestParam String password){

        if (!repositorioUsuario.findByNombreUsuario(username).isEmpty()){

            model.addAttribute("mensajeLog", "LOGEADO DE FORMA CORRECTA");
            model.addAttribute("mensaje", "");
            users_id = repositorioUsuario.findByNombreUsuario(username).get(0).getId();

        }else{

            model.addAttribute("mensajeLog", "USUARIO O CONTRASEÑA INCORRECTOS");
            model.addAttribute("mensaje", "");

        }
        return "registroLogin";
    }
    long numusuarios = 6000;
    @GetMapping("/registro")
    public String RegistroLogin(Model model, @RequestParam String registername, @RequestParam String registerpassword, @RequestParam String email, @RequestParam String direction){

        if (repositorioUsuario.findByEmail(email).isEmpty()){
            repositorioUsuario.save(new Usuario(numusuarios,registername, email, direction, registerpassword));
            numusuarios++;

            model.addAttribute("mensaje", "USUARIO REGISTRADO DE FORMA CORRECTA");
            model.addAttribute("mensajeLog", "");
        }else{
            model.addAttribute("mensaje", "USUARIO YA REGISTRADO");
            model.addAttribute("mensajeLog", "");
        }

        return "registroLogin";
    }

    @GetMapping ("/registroLogin")
    public String RegistroLogin(Model model){
        model.addAttribute("mensaje", "");
        model.addAttribute("mensajeLog", "");

        return "registroLogin";
    }


}
