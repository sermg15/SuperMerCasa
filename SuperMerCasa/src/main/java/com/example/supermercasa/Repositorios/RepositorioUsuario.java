package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

    List<Usuario> findByEmail(String email);
    List<Usuario> findByNombreUsuario(String nombreUsuario);

}
