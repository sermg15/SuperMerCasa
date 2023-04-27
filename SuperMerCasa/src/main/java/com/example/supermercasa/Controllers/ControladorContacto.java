package com.example.supermercasa.Controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorContacto {

    @GetMapping("/contacto")
    public String contacto(Model model){

        return "contacto";
    }
}
