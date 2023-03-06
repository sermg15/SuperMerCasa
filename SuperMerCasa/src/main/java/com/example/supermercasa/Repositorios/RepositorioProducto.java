package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Categoria;
import com.example.supermercasa.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {

    Producto getProductoByName(String nombre);

    List<Producto> findByCategoriasNombre(String nombre);



}
