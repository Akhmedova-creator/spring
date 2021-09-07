package ru.otus.spring.spring_mongo.doman_mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genreMongo")
public class GenreMongo implements Serializable {

    @Id
    private String id;

    @Field
    private String name;

    public GenreMongo(String name) {
        this.name = name;
    }
}
