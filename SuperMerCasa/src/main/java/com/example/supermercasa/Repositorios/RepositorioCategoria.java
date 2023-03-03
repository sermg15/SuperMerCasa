package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCategoria extends CrudRepository<Categoria, Long> {

    Categoria findByNombre (String nombre);
}
