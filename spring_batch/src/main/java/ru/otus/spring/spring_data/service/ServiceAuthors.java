package ru.otus.spring.spring_data.service;

import ru.otus.spring.spring_data.domain.Authors;

import org.springframework.data.domain.Sort;

public interface ServiceAuthors {
    Iterable<Authors> getAuthors();

    Authors findByFirstName(String name);
}
