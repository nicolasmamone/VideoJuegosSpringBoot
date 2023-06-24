package com.nico.videojuegos.repository;

import com.nico.videojuegos.domain.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVideojuegoRepository extends JpaRepository<Videojuego, Integer> {
    //selecciona todas las instancias de la clase Videojuego y ordenalas por el attr nombre
    @Query("SELECT v FROM Videojuego v ORDER BY v.nombre")
    //@Query(" SELECT * FROM videojuego ORDER BY nombre", nativeQuery = true)
    List<Videojuego> buscarTodos();

    @Query("FROM Videojuego v WHERE v.distribuidor.id = ?1 ORDER BY v.nombre")
    List<Videojuego> buscarPorDistribuidor(int distribuidor);

    //@Query("FROM Videojuego v WHERE v.nombre LIKE %?1%")
    //List<Videojuego> buscar(String consulta);
    List<Videojuego> findByNombreContaining(String consulta);

}
