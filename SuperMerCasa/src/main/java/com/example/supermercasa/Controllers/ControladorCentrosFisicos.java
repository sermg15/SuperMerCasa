package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorCentrosFisicos {

    @GetMapping("/centros")
    public String centrosFisicos(Model model){

        return "centrosFisicos";
    }
}
