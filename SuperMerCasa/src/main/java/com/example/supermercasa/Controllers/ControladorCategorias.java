package com.example.supermercasa.Controllers;

import com.example.supermercasa.Repositorios.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControladorCategorias {

    @Autowired
    private RepositorioOferta repositorioOferta;
    @GetMapping("/categoria")
    public String Categorias(Model model,String cat, long id1, long id2, long id3, long id4) {

        model.addAttribute("categoria", cat);

        if(repositorioOferta.findById(id1).isPresent()){
            model.addAttribute("producto1",repositorioOferta.findById(id1).get().getImagen());
            model.addAttribute("nombre1", repositorioOferta.findById(id1).get().getName());
            model.addAttribute("precio1", repositorioOferta.findById(id1).get().getPrecio());
        }

        if(repositorioOferta.findById(id2).isPresent()){
            model.addAttribute("producto2",repositorioOferta.findById(id2).get().getImagen());
            model.addAttribute("nombre2", repositorioOferta.findById(id2).get().getName());
            model.addAttribute("precio2", repositorioOferta.findById(id2).get().getPrecio());
        }

        if(repositorioOferta.findById(id3).isPresent()){
            model.addAttribute("producto3",repositorioOferta.findById(id3).get().getImagen());
            model.addAttribute("nombre3", repositorioOferta.findById(id3).get().getName());
            model.addAttribute("precio3", repositorioOferta.findById(id3).get().getPrecio());
        }

        if(repositorioOferta.findById(id4).isPresent()){
            model.addAttribute("producto4",repositorioOferta.findById(id4).get().getImagen());
            model.addAttribute("nombre4", repositorioOferta.findById(id4).get().getName());
            model.addAttribute("precio4", repositorioOferta.findById(id4).get().getPrecio());
        }



        return "categorias";
    }
}
