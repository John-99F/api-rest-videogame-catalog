package com.videogamecatalog.api_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/catalog/videogames")
public class VideoGameController {
    @Autowired
    VideoGameServices videoGameServices;

    @GetMapping
    public String findAll() {
        List<VideoGame>  response = videoGameServices.findAll();
        if (response.isEmpty()) {
            return "No se encontraron Video Juegos registrados";
        } else {
            return "Se encontraron los siguientes videos juegos:\n"+response;
        }
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        Optional<VideoGame>response = videoGameServices.findById(id);
        if (response.isPresent()) {
            return "Se encontro el siguiente videoJuego:\n"+response;
        } else {
            return "No se encontraron datos";
        }
    }

    @PostMapping
    public String saveOrUpdate(@RequestBody VideoGame videoGame) {
       VideoGame response =  videoGameServices.saveOrUpdate(videoGame);
        if (response != null) {
            return "Respuesta satisfactoria en la base de datos\n"+response;
        } else {
            return "Hubo un error inesperado\n";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
       if(!videoGameServices.deleteById(id)) {
           return "El registro fue eliminado correctamente";
       } else {
           return "Hubo un problema y no se pudo eliminar";
       }
    }
}
