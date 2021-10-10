package ru.otus.spring.domain;

import lombok.Getter;

@Getter
/**
 * сущность,которая соответсвует таблице authors
 */
public class Authors {
    private final String first_name;
    private final String last_name;

    public Authors(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
