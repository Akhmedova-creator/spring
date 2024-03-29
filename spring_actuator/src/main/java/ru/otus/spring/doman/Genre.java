package ru.otus.spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Класс -сущность для документа genre
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genre")
public class Genre {

    @Id
    private String id;

    @Field
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
