package com.videogamecatalog.api_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameServices {

    @Autowired
    VideoGameRepository videoGameRepository;

    public List<VideoGame> findAll() {
        return videoGameRepository.findAll();
    }

    public Optional<VideoGame> findById(Long id) {
        return videoGameRepository.findById(id);
    }

    public VideoGame saveOrUpdate(VideoGame videoGame) {
       return videoGameRepository.save(videoGame);
    }

    public boolean deleteById(Long id) {
        videoGameRepository.deleteById(id);
        return videoGameRepository.existsById(id);
    }
}
