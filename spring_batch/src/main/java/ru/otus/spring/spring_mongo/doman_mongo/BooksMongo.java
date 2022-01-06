package ru.otus.spring.spring_mongo.doman_mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("booksMongo")

public class BooksMongo {

    @Id
    private String id;

    @Field
    private String title;

    @Field
    private GenreMongo genreMongo;

    @Field
    private AuthorsMongo authorsMongo;

    public BooksMongo(String title, GenreMongo genreMongo, AuthorsMongo authorsMongo) {
        this.title = title;
        this.genreMongo = genreMongo;
        this.authorsMongo = authorsMongo;
    }

}


