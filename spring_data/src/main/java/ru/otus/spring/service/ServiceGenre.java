package ru.otus.spring.service;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface ServiceGenre {
    Genre getGenreName(String name);
    List<Genre> getAll();
}
