package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.repository.AuthorsRepository;

import javax.transaction.Transactional;

@Service
public class ServiceAuthorsImpl implements ServiceAuthors {
    @Autowired
    private AuthorsRepository authorsRepository;

    @Transactional
    @Override
    public Iterable<Authors> getAuthors(Sort sort) {
        Iterable<Authors> all = authorsRepository.findAll(sort);
        return all;
    }

    @Transactional
    @Override
    public Authors findByFirstName(String name) {
        return authorsRepository.findByFirstName("Хорстман");
    }
}
