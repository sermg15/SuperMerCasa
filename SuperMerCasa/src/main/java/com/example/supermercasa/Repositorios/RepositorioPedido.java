package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Pedido;
import com.example.supermercasa.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

    Pedido findByUser(Usuario user);

    Pedido findByUserAndId(Usuario user,long id);
}
