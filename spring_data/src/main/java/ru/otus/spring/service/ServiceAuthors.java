package ru.otus.spring.service;

import ru.otus.spring.domain.Authors;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface ServiceAuthors  {
    List<Authors> getAuthors(Sort sort);
    Authors findByFirstName(String name);
}
