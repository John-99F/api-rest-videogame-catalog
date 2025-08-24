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
    public List<VideoGame> findAll() {
        return videoGameServices.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VideoGame> findById(@PathVariable Long id) {
        return videoGameServices.findById(id);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody VideoGame videoGame) {
        videoGameServices.saveOrUpdate(videoGame);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        videoGameServices.deleteById(id);
    }
}
