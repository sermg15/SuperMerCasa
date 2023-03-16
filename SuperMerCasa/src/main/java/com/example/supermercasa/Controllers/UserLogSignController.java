package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.*;
import com.example.supermercasa.Repositorios.RepositorioUsuario;
import com.example.supermercasa.ServicioInterno.servInternoMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UserLogSignController {

    @Autowired
    public RepositorioUsuario repositorioUsuario;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        repositorioUsuario.save(new Usuario("Sergio", "sergio@ejemplo.es", "Calle Ejemplo, 3", passwordEncoder.encode("1234"),null,null, "ADMIN", "USER"));
    }
    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

    }

    @GetMapping("/perfilusuario")
    public String PerfilUsuario(Model model, HttpServletRequest request){

        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user = repositorioUsuario.findByNombreUsuario(principal.getName());

        if(principal != null){
            model.addAttribute("mensaje", "");
            model.addAttribute("name", user.get().getNombreUsuario());
            model.addAttribute("email", user.get().getEmail());
            model.addAttribute("direction", user.get().getDirecction());
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

//    @GetMapping("/logout")
//    public String logout(Model model) {
//        model.addAttribute("notLogged",true);
//        model.addAttribute("logged",false);
//        model.addAttribute("admin",false);
//
//        return "inicio";
//    }

    @GetMapping("/loginerror")
    public String loginerror(Model model){

        model.addAttribute("mensajeLog", "USUARIO O CONTRASEÑA INCORRECTOS");
        model.addAttribute("mensaje", "");

        return "login";
    }

    @GetMapping("/registro")
    public String RegistroLogin(Model model, @RequestParam String registername, @RequestParam String registerpassword, @RequestParam String email, @RequestParam String direction){

        Optional<Usuario> usuario;
        if (repositorioUsuario.findByEmail(email).isEmpty()){
            repositorioUsuario.save(new Usuario(registername, email, direction, passwordEncoder.encode(registerpassword),null,null, "USER"));
            usuario = repositorioUsuario.findByNombreUsuario(registername);

            if(servInternoMail.sendRegisterEmail(usuario.get())){
                model.addAttribute("mensaje", "USUARIO REGISTRADO DE FORMA CORRECTA(CORREO ENVIADO)");
                model.addAttribute("mensajeLog", "");
            }else{
                model.addAttribute("mensaje", "USUARIO REGISTRADO DE FORMA CORRECTA(CORREO NO ENVIADO)");
                model.addAttribute("mensajeLog", "");
            }

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
