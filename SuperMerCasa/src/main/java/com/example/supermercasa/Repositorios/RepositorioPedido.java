package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Pedido;
import com.example.supermercasa.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

    Pedido findByUser(Usuario user);

    Pedido findByUserAndId(Optional<Usuario> user, long id);

   <Optional> Pedido findById(long id);


}
