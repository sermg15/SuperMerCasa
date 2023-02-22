package com.example.supermercasa.Controllers;

import com.example.supermercasa.Entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.supermercasa.Repositorios.RepositorioUsuario;

@Controller
public class ControladorHistorial {

    @GetMapping("/historial")
    public String historialPedidos(Model model){

        model.addAttribute("name", "Juan");


        model.addAttribute("pedido1", "(NumPedido)");
        model.addAttribute("pedido2", "(NumPedido)");
        model.addAttribute("pedido3", "(NumPedido)");
        model.addAttribute("pedido4", "(NumPedido)");

        model.addAttribute("precio1", "(precio)");
        model.addAttribute("precio2", "(precio)");
        model.addAttribute("precio3", "(precio)");
        model.addAttribute("precio4", "(precio)");

        model.addAttribute("fecha1", "(fecha)");
        model.addAttribute("fecha2", "(fecha)");
        model.addAttribute("fecha3", "(fecha)");
        model.addAttribute("fecha4", "(fecha)");

        model.addAttribute("listadoproductos1", "(lista)");
        model.addAttribute("listadoproductos2", "(lista)");
        model.addAttribute("listadoproductos3", "(lista)");
        model.addAttribute("listadoproductos4", "(lista)");
        return "historialPedidos";
    }
}
