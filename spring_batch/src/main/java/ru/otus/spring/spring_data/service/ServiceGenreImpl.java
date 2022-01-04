package ru.otus.spring.spring_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.spring_data.domain.Genre;
import ru.otus.spring.spring_data.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.List;

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
