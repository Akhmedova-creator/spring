package ru.otus.spring.service;

import ru.otus.spring.domain.Authors;

import org.springframework.data.domain.Sort;
public interface ServiceAuthors {
    Iterable<Authors> getAuthors(Sort sort);
    Authors findByFirstName(String name);
}
