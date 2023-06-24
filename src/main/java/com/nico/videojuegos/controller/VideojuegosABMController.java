package com.nico.videojuegos.controller;

import com.nico.videojuegos.domain.Videojuego;
import com.nico.videojuegos.service.DistribuidorService;
import com.nico.videojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class VideojuegosABMController {

    private final DistribuidorService distribuidorService;
    private final VideojuegoService videojuegoService;

    public VideojuegosABMController(DistribuidorService distribuidorService, VideojuegoService videojuegoService) {
        this.distribuidorService = distribuidorService;
        this.videojuegoService = videojuegoService;
    }
    @RequestMapping("/videojuegos/editar")
    public String listarVideoJuegosPorDistribuidor(int id, Model model) {
        Optional<Videojuego> juego = videojuegoService.buscarPorId(id);
        model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        model.addAttribute("videojuego", juego);
        return "formVideojuego";
    }

    @RequestMapping("videojuegos/crear")
    public String mostrarFormAlta(Model model){
        model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        model.addAttribute("videojuego", new Videojuego());
        return "formVideojuego";
    }

    //@RequestMapping(value = "/videojuegos/guardar", method = RequestMethod.POST)
    @PostMapping("/videojuegos/guardar")
    public String guardar(Videojuego videojuego){
        videojuegoService.guardar(videojuego);
        return "redirect:/";
    }
    @RequestMapping("/videojuegos/eliminar")
    public String eliminar(int id){
        videojuegoService.eliminarVideojuego(id);
        return "redirect:/";
    }
}
