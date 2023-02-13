package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ControladorSeguimiento {

    @GetMapping("/seguimiento")
    public String Seguimiento(Model model){


        return "seguimientoPedidos";
    }
}
