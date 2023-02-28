package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Pedido;
import com.example.supermercasa.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

    Pedido findByUser(Usuario user);
}
