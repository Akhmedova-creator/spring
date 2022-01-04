package ru.otus.spring.spring_mongo.service_mongo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.spring_mongo.doman_mongo.GenreMongo;
import ru.otus.spring.spring_mongo.repository_mongo.GenreRepositoryMongo;

import java.util.List;

@Service
public class ServiceGenreMongoImpl implements ServiceGenreMongo {

    private GenreRepositoryMongo genreRepositoryMongo;

    @Transactional
    @Override
    public GenreMongo getGenreName(String name) {
        return genreRepositoryMongo.findByName(name);
    }

    @Transactional
    @Override
    public List<GenreMongo> getAll() {
        return genreRepositoryMongo.findAll();
    }
}
