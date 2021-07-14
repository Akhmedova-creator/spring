package spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "authors")
public class Authors {

    @Id
    private String id;

    @Field("firstname")
    private String firstName;

    @Field("lastname")
    private String lastName;

}
