package spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Document("comments")
@Data
public class Comments {

    @Id
    private String id;

    @Field("commentname")
    private String commentName;

    @Field("commentdata")
    private LocalDate commentData;

}

