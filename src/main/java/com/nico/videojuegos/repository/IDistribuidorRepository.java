package com.nico.videojuegos.repository;

import com.nico.videojuegos.domain.Distribuidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistribuidorRepository extends JpaRepository<Distribuidor, Integer> {


}
