package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.*;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class UserLogSignController {

    @Autowired
    public RepositorioUsuario repositorioUsuario;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public long users_id;

    public long getId(){
        return users_id;
    }
    @PostConstruct
    public void init(){
        repositorioUsuario.save(new Usuario("Sergio", "sergio@ejemplo.es", "Calle Ejemplo, 3", passwordEncoder.encode("1234"),null,null, "ADMIN", "USER"));
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

    @GetMapping("/loginSuccess")
    public String LoginSuccess(Model model){

        model.addAttribute("mensajeLog", "LOGEADO DE FORMA CORRECTA");
        model.addAttribute("mensaje", "");

        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("mensajeLog", "");
        model.addAttribute("mensaje", "");

        return "login";
    }

    @GetMapping("/loginerror")
    public String loginerror(Model model){

        model.addAttribute("mensajeLog", "USUARIO O CONTRASEÑA INCORRECTOS");
        model.addAttribute("mensaje", "");

        return "login";
    }

    @GetMapping("/registro")
    public String RegistroLogin(Model model, @RequestParam String registername, @RequestParam String registerpassword, @RequestParam String email, @RequestParam String direction){

        if (repositorioUsuario.findByEmail(email).isEmpty()){
            repositorioUsuario.save(new Usuario(registername, email, direction, passwordEncoder.encode(registerpassword),null,null, "USER"));

            model.addAttribute("mensaje", "USUARIO REGISTRADO DE FORMA CORRECTA");
            model.addAttribute("mensajeLog", "");
        }else{
            model.addAttribute("mensaje", "USUARIO YA REGISTRADO");
            model.addAttribute("mensajeLog", "");
        }

        return "login";
    }

    @GetMapping ("/registroLogin")
    public String RegistroLogin(Model model){
        model.addAttribute("mensaje", "");
        model.addAttribute("mensajeLog", "");

        return "login";
    }


}
