package com.nico.videojuegos.controller;

import com.nico.videojuegos.domain.Videojuego;
import com.nico.videojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ListadoController {

    private final VideojuegoService videojuegoService;

    public ListadoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }



    // Un metodo con @RequestMapping retorna el nombre del html que se le enviara al navegador
    @RequestMapping("/")
    public String listarVideojuegos(HttpSession session, Model model) {
        session.setAttribute("edit", false);
        List<Videojuego> destacados = videojuegoService.buscarDestacados();
        model.addAttribute("videojuegos", destacados);
        return "listado";
    }

    @RequestMapping("/videojuegosPorDistribuidor")
    public String listarVideoJuegosPorDistribuidor(int distribuidorId, Model model) {
        List<Videojuego> juegos = videojuegoService.buscarPorDistribuidor(distribuidorId);
        model.addAttribute("videojuegos", juegos);
        return "listado";
    }

    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model) {
        List<Videojuego> juegos = videojuegoService.buscar(consulta);
        model.addAttribute("videojuegos", juegos);
        return "listado";
    }
    @RequestMapping("/modoedicion")
    public String modoEdicion(HttpSession session, Model model) {
        session.setAttribute("edit", true);
        System.out.println(session.getAttribute("edit"));

    /*    boolean edit = (boolean) session.getAttribute("edit");
        System.out.println(edit);
        System.out.println("---");
        if (!edit) {
            session.setAttribute("edit", true);
        } else {
            session.setAttribute("edit", false);
        }*/
        List<Videojuego> destacados = videojuegoService.buscarDestacados();
        model.addAttribute("videojuegos", destacados);
        return "listado";
    }
    @RequestMapping("/modouser")
    public String modoUsuario(HttpSession session, Model model) {
        session.setAttribute("edit", false);
        System.out.println(session.getAttribute("edit"));
        List<Videojuego> destacados = videojuegoService.buscarDestacados();
        model.addAttribute("videojuegos", destacados);
        return "listado";
    }

}
