package ru.otus.spring.spring_data.service;

import ru.otus.spring.spring_data.domain.Genre;

import java.util.List;

public interface ServiceGenre {
    Genre getGenreName(String name);

    List<Genre> getAll();
}
