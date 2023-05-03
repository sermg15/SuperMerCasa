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

    @CacheEvict(key = "#product.categorias.get(0).getNombre()")
    Producto save(Producto product);

    @CacheEvict(key = "#product.getCatNombres()")
    void delete(Producto product);

    Producto getProductoByName(String nombre);

    @Cacheable
    List<Producto> findByCategoriasNombre(String nombre);


}
