package spring.doman;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("books")

public class Books {

    @Id
    private String id;

    @Field
    private String title;

    @Field
    private Genre genre;

    @Field
    private Authors authors;

    private List<Comments> comments;


    public Books(String title, Genre genre, Authors authors, List<Comments> comments) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.comments = comments;
    }
}


