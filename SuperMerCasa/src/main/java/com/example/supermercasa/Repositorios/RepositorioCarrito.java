package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Carrito;
import com.example.supermercasa.Entidades.Producto;
import com.example.supermercasa.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RepositorioCarrito extends JpaRepository<Carrito, Long> {
    Carrito findByUser(Usuario user);
    void deleteById(Long id);
}
