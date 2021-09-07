package ru.otus.spring.spring_mongo.service_mongo;

import ru.otus.spring.spring_mongo.doman_mongo.CommentsMongo;

import java.time.LocalDate;

public interface ServiceCommentsMongo {
    CommentsMongo getCommentsByDate(LocalDate date);
}
