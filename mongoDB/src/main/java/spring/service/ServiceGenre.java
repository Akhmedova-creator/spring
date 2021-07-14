package spring.service;

import spring.doman.Genre;

import java.util.List;

public interface ServiceGenre {
    Genre getGenreName(String name);
    List<Genre> getAll();
}
