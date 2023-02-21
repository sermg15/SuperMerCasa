package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioOferta extends JpaRepository<Producto, Long> {

}
