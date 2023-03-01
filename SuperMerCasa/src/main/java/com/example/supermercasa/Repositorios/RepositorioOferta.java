package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioOferta extends JpaRepository<Producto, Long> {

    Producto getProductoByName(String nombre);
}
