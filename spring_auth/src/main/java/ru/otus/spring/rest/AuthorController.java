package ru.otus.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.repository.AuthorsRepository;
import ru.otus.spring.rest.dto.AuthorDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private final AuthorsRepository authorsRepository;

    public AuthorController(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    @GetMapping("/authors")
    public List<AuthorDto> getAuthors() {
        return authorsRepository.findAll().stream().map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }
}
