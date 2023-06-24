package com.nico.videojuegos.service;

import com.nico.videojuegos.domain.Videojuego;
import com.nico.videojuegos.repository.IVideojuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService {
    private final IVideojuegoRepository videojuegoRepository;

    public VideojuegoService(IVideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    public Optional<Videojuego> buscarPorId(Integer id) {
        return videojuegoRepository.findById(id);
    }

    public List<Videojuego> buscarDestacados() {
        return videojuegoRepository.buscarTodos();
    }

    public List<Videojuego> buscarPorDistribuidor(int distribuidorId) {
        return videojuegoRepository.buscarPorDistribuidor(distribuidorId);
    }

    public List<Videojuego> buscar(String consulta) {
        return videojuegoRepository.findByNombreContaining(consulta);
    }

    //guarda si id es null o actualiza si id tiene algun valor
    public Videojuego guardar(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    public void eliminarVideojuego(int id){
        videojuegoRepository.deleteById(id);
    }
}
