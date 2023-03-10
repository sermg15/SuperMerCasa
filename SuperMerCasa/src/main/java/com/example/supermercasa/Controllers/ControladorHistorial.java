package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Usuario;
import com.example.supermercasa.Repositorios.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.supermercasa.Repositorios.RepositorioUsuario;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.security.Principal;
import java.util.Optional;

@Controller
public class ControladorHistorial {
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioPedido repositorioPedido;


    @GetMapping("/historial")
    public String historialPedidos(Model model, HttpServletRequest request){

        Principal principal = request.getUserPrincipal();
        Optional<Usuario> user = repositorioUsuario.findByNombreUsuario(principal.getName());

        model.addAttribute("name",user.get().getNombreUsuario());
        model.addAttribute("pedidos",user.get().getPedidos());
        return "historialPedidos";
    }
}
