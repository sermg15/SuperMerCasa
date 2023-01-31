package com.example.supermercasa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebaController {

    @GetMapping("/salute")
    public String salute(Model model){

        model.addAttribute("user", "Mario");
        return "salute";
    }
}
