package ru.otus.spring.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Репозиторий для сущноси Aurhors
 */
@Repository
public class AuthorsDaoJdbc implements AuthorsDao {

    private final NamedParameterJdbcOperations jdbc;

    public AuthorsDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     *
     * @param firstName поле в cущности Authors
     * @param lastName  поле в cущности Authors
     * @return возвращает id по  firstName,lastName
     */
    @Override
    public int getIdByFirstName(String firstName, String lastName) {
        return jdbc.queryForObject("select id from authors " +
                        "where first_name=:firstName " +
                        "and last_name=:lastName",
                Map.of("firstName",
                        firstName,
                        "lastName",
                        lastName),
                Integer.class);
    }
}
