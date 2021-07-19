package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.GenreRepository;

import java.util.List;

;

@Service
public class ServiceGenreImpl implements ServiceGenre {
    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    @Override
    public Genre getGenreName(String name) {
        return genreRepository.findByName(name);
    }

    @Transactional
    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
