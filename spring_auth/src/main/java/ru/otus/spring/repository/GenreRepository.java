package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @PostFilter("hasPermission(filterObject, 'READ')")
    List<Genre> findAll();

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Genre getById(Long id);
}
