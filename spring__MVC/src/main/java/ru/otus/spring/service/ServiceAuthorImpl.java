package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.doman.Author;
import ru.otus.spring.repository.AuthorRepository;

@Service
public class ServiceAuthorImpl implements ServiceAuthor {
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Iterable<Author> getAuthors(Sort sort) {
        Iterable<Author> all = authorRepository.findAll(sort);
        return all;
    }

    @Transactional
    @Override
    public Author findByFirstName(String name) {
        return authorRepository.findByFirstName("Хорстман");
    }
}
