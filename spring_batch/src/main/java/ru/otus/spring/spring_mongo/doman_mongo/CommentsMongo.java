package ru.otus.spring.spring_mongo.doman_mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Document("commentsMongo")
@Data
public class CommentsMongo {

    @Id
    private String id;

    @Field
    private String commentName;

    @Field
    private LocalDate commentData;

    @Field
    private BooksMongo booksMongo;

}

