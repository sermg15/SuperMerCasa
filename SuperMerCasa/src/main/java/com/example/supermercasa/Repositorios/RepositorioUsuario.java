package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

    List<Usuario> findByEmail(String email);
    List<Usuario> findByNombreUsuario(String nombreUsuario);

}
