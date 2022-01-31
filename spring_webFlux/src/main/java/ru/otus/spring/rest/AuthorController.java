package ru.otus.spring.rest;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.rest.dto.AuthorDto;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public Flux<AuthorDto> getAuthors() {
        return authorRepository.findAll().map(AuthorDto::toDto);
    }
}
