package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RepositorioCarrito extends JpaRepository<Carrito,Integer> {
    Carrito findByUser(Usuario user);
}
