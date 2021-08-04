package ru.otus.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.rest.dto.GenreDto;

@RestController
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genres")
    public Flux<GenreDto> getGenres() {
        return genreRepository.findAll().map(GenreDto::toDto);
    }
}
