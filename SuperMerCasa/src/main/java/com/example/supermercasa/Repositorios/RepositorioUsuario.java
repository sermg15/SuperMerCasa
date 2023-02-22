package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioUsuario extends CrudRepository<Usuario, Integer> {


}
