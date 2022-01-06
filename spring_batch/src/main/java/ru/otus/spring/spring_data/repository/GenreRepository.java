package ru.otus.spring.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.spring_data.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
