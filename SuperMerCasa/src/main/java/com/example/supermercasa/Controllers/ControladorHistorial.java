package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorHistorial {

    @GetMapping("/historial")
    public String historialPedidos(Model model){

        return "historialPedidos";
    }
}
