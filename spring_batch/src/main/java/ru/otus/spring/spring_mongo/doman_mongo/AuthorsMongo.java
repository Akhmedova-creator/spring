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
@Document(collection = "authorsMongo")
public class AuthorsMongo {

    @Id
    private String id;

    @Field("firstname")
    private String firstName;

    @Field("lastname")
    private String lastName;

    public AuthorsMongo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
