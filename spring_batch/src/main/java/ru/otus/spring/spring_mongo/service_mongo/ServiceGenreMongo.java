package ru.otus.spring.spring_mongo.service_mongo;

import ru.otus.spring.spring_mongo.doman_mongo.GenreMongo;

import java.util.List;

public interface ServiceGenreMongo {
    GenreMongo getGenreName(String name);

    List<GenreMongo> getAll();
}
