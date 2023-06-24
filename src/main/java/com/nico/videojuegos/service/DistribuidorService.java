package com.nico.videojuegos.service;

import com.nico.videojuegos.domain.Distribuidor;
import com.nico.videojuegos.repository.IDistribuidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidorService {
    private final IDistribuidorRepository distribuidorRepository;

    public DistribuidorService(IDistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }

    public List<Distribuidor> buscarTodos(){
        return distribuidorRepository.findAll();
    }
}
