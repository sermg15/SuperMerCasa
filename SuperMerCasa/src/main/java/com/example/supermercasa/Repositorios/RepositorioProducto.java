package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProducto extends JpaRepository<Producto, Long> {

}
