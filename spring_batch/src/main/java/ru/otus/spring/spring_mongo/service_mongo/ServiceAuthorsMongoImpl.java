package ru.otus.spring.spring_mongo.service_mongo;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.spring_mongo.doman_mongo.AuthorsMongo;
import ru.otus.spring.spring_mongo.repository_mongo.AuthorsRepositoryMongo;

@Service
public class ServiceAuthorsMongoImpl implements ServiceAuthorsMongo {
    private AuthorsRepositoryMongo authorsRepositoryMongo;

    @Transactional
    @Override
    public Iterable<AuthorsMongo> getAuthors(Sort sort) {
        Iterable<AuthorsMongo> all = authorsRepositoryMongo.findAll(sort);
        return all;
    }

    @Transactional
    @Override
    public AuthorsMongo findByFirstName(String name) {
        return authorsRepositoryMongo.findByFirstName("Хорстман");
    }
}
