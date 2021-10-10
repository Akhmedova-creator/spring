package ru.otus.spring.dao;

public interface AuthorsDao {
    int getIdByFirstName(String firstName, String lastName);
}
