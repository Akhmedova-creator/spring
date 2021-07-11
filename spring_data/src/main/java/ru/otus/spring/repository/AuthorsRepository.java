package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.domain.Authors;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    Authors findByFirstName(String name);
}
