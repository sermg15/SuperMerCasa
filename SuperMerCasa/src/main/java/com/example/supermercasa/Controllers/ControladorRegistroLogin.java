package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ControladorRegistroLogin {

    @GetMapping("/registroLogin")
    public String RegistroLogin(Model model){


        return "registroLogin";
    }
}
