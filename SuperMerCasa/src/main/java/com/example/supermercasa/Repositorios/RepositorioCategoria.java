package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

    Categoria findByNombre(String nombre);
}
