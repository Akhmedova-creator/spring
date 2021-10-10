package ru.otus.spring.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * репозиторий для Books
 */
@Repository
public class GenreDaoJdbc implements GenreDao {
    private final NamedParameterJdbcOperations jdbc;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * получение id жанра
     * @param name имя genre
     * @return возвращает id жанра по имени жанра
     */
    @Override
    public Integer getIdByName(String name) {
        return jdbc.queryForObject("select id from genre where name=:name",
                Map.of("name",
                        name),
                Integer.class);
    }


}
