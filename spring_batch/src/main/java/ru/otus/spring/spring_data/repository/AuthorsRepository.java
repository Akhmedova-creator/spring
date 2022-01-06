package ru.otus.spring.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.spring_data.domain.Authors;

import java.util.List;


public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    Authors findByFirstName(String name);

    List<Authors> findAll();
}
