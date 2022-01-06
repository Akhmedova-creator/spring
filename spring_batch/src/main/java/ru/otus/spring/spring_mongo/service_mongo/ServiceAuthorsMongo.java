package ru.otus.spring.spring_mongo.service_mongo;

import org.springframework.data.domain.Sort;
import ru.otus.spring.spring_mongo.doman_mongo.AuthorsMongo;

public interface ServiceAuthorsMongo {
    Iterable<AuthorsMongo> getAuthors(Sort sort);

    AuthorsMongo findByFirstName(String name);
}
