package ru.otus.spring.doman;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Класс -сущность для документа book
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("book")

public class Book {

    @Id
    private String id;

    @Field
    private String title;

    @Field
    private Genre genre;

    @Field
    private Author author;

    public Book(String title, Genre genre, Author author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }
}


