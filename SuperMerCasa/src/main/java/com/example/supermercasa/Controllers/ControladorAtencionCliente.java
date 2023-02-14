package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorAtencionCliente {
    @GetMapping("/atencionalcliente")
    public String AtencionAlCliente(Model model) {

        return "AtencionAlCliente";
    }

}
