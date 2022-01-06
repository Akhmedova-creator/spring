package ru.otus.spring.spring_mongo.service_mongo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.spring_mongo.doman_mongo.CommentsMongo;
import ru.otus.spring.spring_mongo.repository_mongo.CommentsRepositoryMongo;

import java.time.LocalDate;

@Service
public class ServiceCommentsMongoImpl implements ServiceCommentsMongo {

    private CommentsRepositoryMongo commentsRepositoryMongo;

    @Transactional
    @Override
    public CommentsMongo getCommentsByDate(LocalDate date) {
        return commentsRepositoryMongo.findByCommentData(date);
    }
}
