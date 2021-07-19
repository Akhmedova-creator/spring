package ru.otus.spring.service;

import org.springframework.data.domain.Sort;
import ru.otus.spring.doman.Author;

public interface ServiceAuthor {
    Iterable<Author> getAuthors(Sort sort);

    Author findByFirstName(String name);
}
