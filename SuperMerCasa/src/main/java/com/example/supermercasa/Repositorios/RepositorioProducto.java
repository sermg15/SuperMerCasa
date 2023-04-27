package com.example.supermercasa.Repositorios;

import com.example.supermercasa.Entidades.Categoria;
import com.example.supermercasa.Entidades.Producto;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@CacheConfig(cacheNames="productos")
@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {

//    List<Categorias> c = new Categoria();
//
//    void guardar(Producto p){
//
//        c = p.getCategorias();
//    }

    @CacheEvict(key = "nombre")
    Producto save(Producto product);

    @CacheEvict(allEntries = true)
    void delete(Producto product);

    @Cacheable
    Producto getProductoByName(String nombre);

    @Cacheable
    List<Producto> findByCategoriasNombre(String nombre);



}
